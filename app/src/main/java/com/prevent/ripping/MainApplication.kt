package com.prevent.ripping

import android.app.Application
import com.prevent.alertmap.alertMapModule
import com.prevent.data.recorddata.recordDataModule
import com.prevent.feature.alertmap_data.alertMapDataModule
import com.prevent.feature.record.recordModule
import com.prevent.feature.setting.settingModule
import com.prevent.util.utilModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            alertMapModule,
            recordModule,
            recordDataModule,
            utilModule,
            settingModule
        ) + alertMapDataModule

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}
