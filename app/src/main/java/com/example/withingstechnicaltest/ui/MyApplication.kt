package com.example.withingstechnicaltest.ui

import android.app.Application
import com.example.withingstechnicaltest.BuildConfig
import com.example.withingstechnicaltest.domain.di.koinDomainModules
import com.example.withingstechnicaltest.repository.di.koinRepositoryModules
import com.example.withingstechnicaltest.ui.di.koinUiModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Do not delete, used in AndroidManifest
 */
class MyApplication : Application() {

    override fun onCreate() {
        startKoin {
            androidContext(this@MyApplication)
            modules(koinDomainModules)
            modules(koinRepositoryModules)
            modules(koinUiModules)
        }
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}