package com.example.withingstechnicaltest.ui.search_images.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_search_image.view.*

class SearchImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(imageSearchUi: ImageSearchUi, isActivated: Boolean) {
        Picasso
            .get()
            .load(imageSearchUi.webformatURL)
            .into(itemView.holder_search_image_preview)
        itemView.holder_search_image_checkbox.isChecked = isActivated
    }

    fun clicked() {
        itemView.holder_search_image_checkbox.isChecked = !itemView.holder_search_image_checkbox.isChecked
    }
}