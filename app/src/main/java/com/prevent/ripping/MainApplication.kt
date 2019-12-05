package com.prevent.ripping

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val modules = listOf(module {})

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}