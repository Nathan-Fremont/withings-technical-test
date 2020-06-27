package com.example.withingstechnicaltest.repository

import com.example.withingstechnicaltest.repository.api.model.ImageListSearchApi
import io.reactivex.Single

interface ApiDataSource {

    fun searchImages(query: String): Single<ImageListSearchApi>
}