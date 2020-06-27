package com.example.withingstechnicaltest.repository

import com.example.withingstechnicaltest.domain.Repository
import com.example.withingstechnicaltest.domain.model.ImageListSearch
import com.example.withingstechnicaltest.repository.mapper.ImageListSearchMapper
import io.reactivex.Single

class RepositoryImpl(
    private val apiDataSource: ApiDataSource,
    private val imageListSearchMapper: ImageListSearchMapper
) : Repository {
    override fun searchImages(query: String): Single<ImageListSearch> {
        return apiDataSource.searchImages(query)
            .map { imageListSearchApi ->
                imageListSearchMapper.toDomain(imageListSearchApi)
            }
    }
}