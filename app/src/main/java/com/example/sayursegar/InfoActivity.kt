package com.example.sayursegar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        // Ambil data sayur dari intent
        val sayur = intent.getStringExtra("sayur")

        // Tampilkan informasi sayur sesuai dengan data yang diterima
        when (sayur) {
            "bayam" -> {
                // Tampilkan informasi bayam
                println("Informasi tentang sayur bayam")
            }
            "wortel" -> {
                // Tampilkan informasi wortel
                println("Informasi tentang sayur wortel")
            }
            else -> {
                // Tampilkan pesan jika sayur tidak ditemukan
                println("Sayur tidak ditemukan")
            }
        }
    }
}
