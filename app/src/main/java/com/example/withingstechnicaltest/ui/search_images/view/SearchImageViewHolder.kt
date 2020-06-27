package com.example.withingstechnicaltest.ui.search_images.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_search_image.view.*

class SearchImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(imageSearchUi: ImageSearchUi) {
        Picasso
            .get()
            .load(imageSearchUi.webformatURL)
            .into(itemView.holder_search_image_preview)
    }
}