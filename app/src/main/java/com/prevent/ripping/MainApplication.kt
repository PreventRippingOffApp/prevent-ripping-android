package com.prevent.ripping

import android.app.Application
import com.prevent.alertmap.alertMapModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val modules = listOf(alertMapModule)

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}