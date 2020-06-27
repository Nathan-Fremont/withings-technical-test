package com.example.withingstechnicaltest.ui.search_images.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.withingstechnicaltest.R
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import com.example.withingstechnicaltest.ui.search_images.view.SearchImageViewHolder

class SearchImagesAdapter : ListAdapter<ImageSearchUi, SearchImageViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.holder_search_image, parent, false)
        val holder = SearchImageViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: SearchImageViewHolder, position: Int) {
        val imageUi = getItem(position)
        holder.bind(
            imageUi
        )
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