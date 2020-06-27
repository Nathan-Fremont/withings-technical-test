package com.example.withingstechnicaltest.repository.di

import com.example.withingstechnicaltest.domain.Repository
import com.example.withingstechnicaltest.repository.ApiDataSource
import com.example.withingstechnicaltest.repository.RepositoryImpl
import com.example.withingstechnicaltest.repository.api.ApiDataSourceImpl
import com.example.withingstechnicaltest.repository.api.retrofit.ApiRetrofitFactory
import com.example.withingstechnicaltest.repository.mapper.ImageListSearchMapper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiRetrofitModule = module {
    single {
        ApiRetrofitFactory(androidContext()).buildApiService(
            ApiRetrofitFactory(androidContext()).buildApiRetrofit()
        )
    }
}

val apiDataSourceModule = module {
    single {
        ApiDataSourceImpl(
            apiService = get()
        ) as ApiDataSource
    }
}

val repositoryModule = module {
    single {
        RepositoryImpl(
            apiDataSource = get(),
            imageListSearchMapper = get()
        ) as Repository
    }
}

val apiMapperModule = module {
    single {
        ImageListSearchMapper()
    }
}

val koinRepositoryModules = listOf(
    apiRetrofitModule,
    apiDataSourceModule,
    repositoryModule,
    apiMapperModule
)