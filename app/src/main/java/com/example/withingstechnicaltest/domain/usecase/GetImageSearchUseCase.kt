package com.example.withingstechnicaltest.domain.usecase

import com.example.withingstechnicaltest.domain.Repository
import com.example.withingstechnicaltest.domain.model.ImageListSearch
import io.reactivex.Single

class GetImageSearchUseCase(private val repository: Repository) {
    operator fun invoke(query: String): Single<ImageListSearch> {
        return repository.searchImages(query)
    }
}