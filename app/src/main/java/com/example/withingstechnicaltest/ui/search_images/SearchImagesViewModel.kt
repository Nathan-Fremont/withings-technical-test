package com.example.withingstechnicaltest.ui.search_images

import com.example.withingstechnicaltest.domain.usecase.GetImageSearchUseCase
import com.example.withingstechnicaltest.ui.common.BaseViewModel
import com.example.withingstechnicaltest.ui.search_images.mapper.ImageSearchUiMapper
import com.example.withingstechnicaltest.ui.search_images.model.ImageSearchUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class SearchImagesViewModel(
    private val getImageSearchUseCase: GetImageSearchUseCase,
    private val imageSearchUiMapper: ImageSearchUiMapper
) : BaseViewModel<List<ImageSearchUi>>(){

    init {

    }

    fun searchImagesWithQuery(query: String?) {
        if (query != null) {
            getImageSearchUseCase(query)
                .subscribeOn(Schedulers.io())
                .map { imageListSearch ->
                    imageSearchUiMapper.toUi(imageListSearch)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {
                        postUiData(it)
                    }
                )
        }
    }
}