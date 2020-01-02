package com.prevent.data.flags

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val flagsModule = module {
    factory { FlagsImpl(androidApplication()) as Flags }
}
