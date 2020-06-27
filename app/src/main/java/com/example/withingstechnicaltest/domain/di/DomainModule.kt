package com.example.withingstechnicaltest.domain.di

import com.example.withingstechnicaltest.domain.usecase.GetImageSearchUseCase
import org.koin.dsl.module

val domainUseCaseModule = module {
    factory {
        GetImageSearchUseCase(
            repository = get()
        )
    }
}

val koinDomainModules = listOf(
    domainUseCaseModule
)