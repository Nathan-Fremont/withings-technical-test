package com.example.withingstechnicaltest.repository.api

import com.example.withingstechnicaltest.repository.ApiDataSource
import com.example.withingstechnicaltest.repository.api.model.ImageListSearchApi
import com.example.withingstechnicaltest.repository.api.retrofit.ApiService
import io.reactivex.Single

class ApiDataSourceImpl (
    private val apiService: ApiService
): ApiDataSource {
    override fun searchImages(query: String): Single<ImageListSearchApi> {
        return apiService.searchImages(query)
    }
}