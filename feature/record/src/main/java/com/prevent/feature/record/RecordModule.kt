package com.prevent.feature.record

import com.prevent.feature.record.domain.RecordService
import com.prevent.feature.record.domain.RecordServiceImpl
import org.koin.dsl.module

val recordModule = module {
    factory { RecordServiceImpl() as RecordService }
}