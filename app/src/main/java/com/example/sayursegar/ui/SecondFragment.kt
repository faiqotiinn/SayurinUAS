package com.example.sayursegar.ui

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sayursegar.R
import com.example.sayursegar.application.FreshApp
import com.example.sayursegar.databinding.FragmentSecondBinding
import com.example.sayursegar.model.Fresh
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val freshViewModel: FreshViewModel by viewModels {
        FreshViewModelFactory((applicationContext as FreshApp).repository)
    }

    private val args : SecondFragmentArgs by navArgs()
    private var fresh: Fresh? = null
    private lateinit var mMap: GoogleMap
    private var currentLatLang: LatLng?= null
    private lateinit var fusedLocationClient:FusedLocationProviderClient

    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fresh = args.fresh

        if (fresh != null) {
            binding.deletebutton.visibility = View.VISIBLE
            binding.saveButton.text = "Ubah"
            binding.nameeditText.setText(fresh?.name)
            binding.addreseditText.setText(fresh?.address)
            binding.typeEditText.setText(fresh?.type)
        }

        //binding map
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        checkPermission()

        val name = binding.nameeditText.text
        val address = binding.addreseditText.text
        val type = binding.typeEditText.text
        binding.saveButton.setOnClickListener {

            if (name.isEmpty()) {
                Toast.makeText(context, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (address.isEmpty()) {
                Toast.makeText(context, "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (type.isEmpty()) {
                Toast.makeText(context, "Jenis tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }else{

                if (fresh == null) {
                    val fresh = Fresh(0, name.toString(), address.toString(), type.toString(), currentLatLang?.latitude, currentLatLang?.longitude)
                    freshViewModel.insert(fresh)
                }else{
                    val fresh = Fresh(fresh?.id!!, name.toString(), address.toString(), type.toString(), currentLatLang?.latitude, currentLatLang?.longitude)
                    freshViewModel.update(fresh)
                }
                findNavController().popBackStack()
            }
        }

        binding.deletebutton.setOnClickListener {
            fresh?.let {freshViewModel.delete(it) }
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap:GoogleMap) {
        mMap = googleMap

        //implement drag marker
        mMap.setOnMarkerDragListener(this)

        val uiSettings = mMap.uiSettings
        uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerDragListener(this)
    }

    override fun onMarkerDrag(p0: Marker) {}

    override fun onMarkerDragEnd(marker: Marker) {
        val newPosition = marker.position
        currentLatLang = LatLng(newPosition.latitude, newPosition.longitude)
        Toast.makeText(context, currentLatLang.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onMarkerDragStart(p0: Marker) {
    }
    private fun checkPermission(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext)
        if (ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ){
            getCurrentLocation()
        }else{
            Toast.makeText(applicationContext,"Akses lokasi ditolak", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getCurrentLocation (){
        // ngecek jika permisi tidak disetujui maka akan berhenti di kondisi if
        if (ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ){
        return
    }
        //untuk test current location
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if(location != null){
                    var latLang = LatLng(location.latitude, location.longitude)
                    currentLatLang = latLang
                    var title = "Marker"

                    if (fresh != null) {
                        title = fresh?.name.toString()
                        val newCurrentLocation = LatLng(fresh?.latitude!!, fresh?.longitude!!)
                        latLang = newCurrentLocation
                    }
                    val markerOption = MarkerOptions()
                        .position(latLang)
                        .title(title)
                        .draggable(true)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.vegetables))

                    mMap.addMarker(markerOption)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLang,15f))
                }

            }
    }
}