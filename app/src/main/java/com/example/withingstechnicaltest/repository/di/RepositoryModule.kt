package com.example.withingstechnicaltest.repository.di

import com.example.withingstechnicaltest.repository.api.retrofit.ApIRetrofitFactory
import com.example.withingstechnicaltest.repository.mapper.ImageListSearchMapper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val apiRetrofitModule = module {
    single {
        ApIRetrofitFactory(androidContext()).buildApiService(
            ApIRetrofitFactory(androidContext()).buildApiRetrofit()
        )
    }
}

val apiMapperModule = module {
    single {
        ImageListSearchMapper()
    }
}

val koinRepositoryModules = listOf(
    apiRetrofitModule,
    apiMapperModule
)