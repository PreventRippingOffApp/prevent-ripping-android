package com.prevent.util

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val utilModule = module {
    factory { VibrationServiceImpl(androidApplication()) as VibrationService }
}