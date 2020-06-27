package com.example.withingstechnicaltest.ui.search_images.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageSearchUi(
    val id: Long,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val webformatURL: String,
    val largeImageURL: String
) : Parcelable