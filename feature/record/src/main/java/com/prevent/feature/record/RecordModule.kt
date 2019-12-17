package com.prevent.feature.record

import com.prevent.feature.record.domain.RecordService
import com.prevent.feature.record.domain.RecordServiceImpl
import kotlinx.coroutines.GlobalScope
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val recordModule = module {
    factory { RecordServiceImpl(GlobalScope, androidApplication()) as RecordService }
}