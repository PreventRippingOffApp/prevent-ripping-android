package com.prevent.data.recorddata

import com.prevent.data.recorddata.impl.RecordDataRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val recordDataModule = module {
    factory { RecordDataRepositoryImpl(androidApplication()) as RecordDataRepository }
    factory { RecordDataRepositoryImpl(androidApplication()) as RecordDataReadonlyRepository }
}