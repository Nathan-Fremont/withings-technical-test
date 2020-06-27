package com.example.withingstechnicaltest.repository.api.retrofit

import android.content.Context
import com.example.withingstechnicaltest.BuildConfig
import com.example.withingstechnicaltest.repository.ApiDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApIRetrofitFactory(private val context: Context) {
    fun buildApiRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(buildHttpClient())
            .baseUrl("https://mytest.fr/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(buildMoshi()))
            .build()
    }

    fun buildApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    fun buildHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(buildHttpLoggingInterceptor())
            .build()
    }

    private fun buildHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    fun buildMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}