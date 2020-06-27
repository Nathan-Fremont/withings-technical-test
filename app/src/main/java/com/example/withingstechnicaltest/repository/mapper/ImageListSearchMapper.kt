package com.example.withingstechnicaltest.repository.mapper

import com.example.withingstechnicaltest.domain.model.ImageListSearch
import com.example.withingstechnicaltest.domain.model.ImageSearch
import com.example.withingstechnicaltest.repository.api.model.ImageListSearchApi

class ImageListSearchMapper : BaseDomainMapper<ImageListSearchApi, ImageListSearch>() {
    override fun toDomain(api: ImageListSearchApi): ImageListSearch {
        val listOfImages = api.hits.map {  imageSearchApi ->
            ImageSearch(
                imageSearchApi.id,
                imageSearchApi.pageURL,
                imageSearchApi.type,
                imageSearchApi.tags,
                imageSearchApi.previewURL,
                imageSearchApi.previewWidth,
                imageSearchApi.previewHeight,
                imageSearchApi.webformatURL,
                imageSearchApi.webformatWidth,
                imageSearchApi.webformatHeight,
                imageSearchApi.largeImageURL,
                imageSearchApi.imageWidth,
                imageSearchApi.imageHeight,
                imageSearchApi.imageSize,
                imageSearchApi.views,
                imageSearchApi.downloads,
                imageSearchApi.favorites,
                imageSearchApi.likes,
                imageSearchApi.comments,
                imageSearchApi.user_id,
                imageSearchApi.user,
                imageSearchApi.userImageURL
            )
        }
        return ImageListSearch(
            api.total,
            api.totalHits,
            listOfImages
        )
    }
}