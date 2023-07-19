package com.example.freshapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sayursegar.R
import com.example.sayursegar.model.Fresh
import com.example.sayursegar.ui.FreshViewModel

class FreshListAdapter(
    private val onItemClickListener: (Fresh) -> Unit
): ListAdapter<Fresh, FreshListAdapter.FreshViewModel>(WORDS_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FreshViewModel {
        return FreshViewModel.create(parent)
    }
    override fun onBindViewHolder(holder: FreshViewModel, position: Int) {
        val fresh = getItem(position)
        holder.bind(fresh)
        holder.itemView.setOnClickListener {
            onItemClickListener(fresh)
        }
    }

    class FreshViewModel (itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        private val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)

        fun bind(fresh: Fresh?) {
            nameTextView.text = fresh?.name
            fresh?.name?.let { Log.d("Sayfresh", it) }
            addressTextView.text = fresh?.address
            typeTextView.text = fresh?.type

        }

        companion object {
            fun create(parent: ViewGroup): FreshListAdapter.FreshViewModel {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_fresh, parent, false)
                return FreshViewModel(view)
            }
        }

    }
    companion object{
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Fresh>(){
            override fun areItemsTheSame(oldItem: Fresh, newItem: Fresh): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Fresh, newItem: Fresh): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
