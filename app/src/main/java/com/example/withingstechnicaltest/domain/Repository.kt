package com.example.withingstechnicaltest.domain

import com.example.withingstechnicaltest.domain.model.ImageListSearch
import io.reactivex.Single

interface Repository {
    fun searchImages(query: String): Single<ImageListSearch>
}