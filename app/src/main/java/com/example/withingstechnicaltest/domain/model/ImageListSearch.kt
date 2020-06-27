package com.example.withingstechnicaltest.domain.model

import com.example.withingstechnicaltest.repository.api.model.ImageSearchApi

data class ImageListSearch(
    val total: Int,
    val totalHits: Int,
    val hits: List<ImageSearch>
)

data class ImageSearch(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val favorites: Int,
    val likes: Int,
    val comments: Int,
    val user_id: Int,
    val user: String,
    val userImageURL: String
)