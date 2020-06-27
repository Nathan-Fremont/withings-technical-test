package com.example.withingstechnicaltest.ui.search_images.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.withingstechnicaltest.R
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import com.example.withingstechnicaltest.ui.search_images.view.SearchImageViewHolder
import timber.log.Timber

class SearchImagesAdapter(private val selectedItems: ArrayList<ImageSearchUi>) : ListAdapter<ImageSearchUi, SearchImageViewHolder>(diffCallback) {

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchImageViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_search_image, parent, false)
        val holder = SearchImageViewHolder(view).apply {
            itemView.setOnClickListener {
                val imageUi = getItem(adapterPosition)
                Timber.d("Click on item at position $adapterPosition")
                if (itemView.isActivated) {
                    selectedItems.remove(imageUi)
                } else {
                    selectedItems.add(imageUi)
                }
                itemView.isActivated = !itemView.isActivated
            }
        }
        return holder
    }

    override fun onBindViewHolder(holder: SearchImageViewHolder, position: Int) {
        val imageUi = getItem(position)
        val isSelected = selectedItems.contains(imageUi)
        Timber.d("isSelected = $isSelected")
        holder.bind(
            imageUi,
            isSelected
        )
    }

    override fun getItemId(position: Int): Long {
        val imageUi = getItem(position)
        return imageUi.id
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ImageSearchUi>() {
            override fun areItemsTheSame(
                oldItem: ImageSearchUi,
                newItem: ImageSearchUi
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ImageSearchUi,
                newItem: ImageSearchUi
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}