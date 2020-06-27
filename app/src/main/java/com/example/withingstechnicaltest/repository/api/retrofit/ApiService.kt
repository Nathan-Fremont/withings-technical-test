package com.example.withingstechnicaltest.repository.api.retrofit

import com.example.withingstechnicaltest.repository.api.model.ImageListSearchApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api")
    fun searchImages(@Query(value = "q") query: String): Single<ImageListSearchApi>
}