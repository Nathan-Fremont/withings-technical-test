package com.example.withingstechnicaltest.ui.search_images.model

data class ImageSearchUi(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val webformatURL: String,
    val largeImageURL: String
)