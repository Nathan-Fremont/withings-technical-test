package com.example.withingstechnicaltest.ui.di

import com.example.withingstechnicaltest.ui.search_images.SearchImagesViewModel
import com.example.withingstechnicaltest.ui.search_images.mapper.ImageSearchUiMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiSearchImageViewModelModule = module {
    single {
        ImageSearchUiMapper()
    }
    viewModel {
        SearchImagesViewModel(
            getImageSearchUseCase = get(),
            imageSearchUiMapper = get()
        )
    }
}

val koinUiModules = listOf(
    uiSearchImageViewModelModule
)