package com.example.withingstechnicaltest.ui

import android.app.Application
import com.example.withingstechnicaltest.domain.di.koinDomainModules
import com.example.withingstechnicaltest.repository.di.koinRepositoryModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Do not delete, used in AndroidManifest
 */
class MyApplication : Application() {

    override fun onCreate() {
        startKoin {
            modules(koinDomainModules)
            modules(koinRepositoryModules)
        }
        super.onCreate()
    }
}