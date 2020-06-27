package com.example.withingstechnicaltest.ui.search_images.mapper

import com.example.withingstechnicaltest.domain.model.ImageListSearch
import com.example.withingstechnicaltest.ui.common.BaseUiMapper
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi

class ImageSearchUiMapper : BaseUiMapper<ImageListSearch, List<ImageSearchUi>>() {
    override fun toUi(domain: ImageListSearch): List<ImageSearchUi> {
        return domain.hits
            .map { imageSearch ->
                ImageSearchUi(
                    imageSearch.pageURL,
                    imageSearch.type,
                    imageSearch.tags,
                    imageSearch.previewURL,
                    imageSearch.webformatURL,
                    imageSearch.largeImageURL
                )
            }
    }
}