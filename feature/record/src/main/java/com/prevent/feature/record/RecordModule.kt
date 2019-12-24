package com.prevent.feature.record

import com.prevent.feature.record.domain.RecordService
import com.prevent.feature.record.domain.RecordServiceImpl
import com.prevent.feature.record.list.RecordListDialogViewModel
import com.prevent.feature.record.list.RecordListLiveDataFactory
import kotlinx.coroutines.GlobalScope
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recordModule = module {
    factory { RecordServiceImpl(GlobalScope, androidApplication(), get()) as RecordService }

    // LiveData
    factory { RecordListLiveDataFactory(get(), get()) }

    // ViewModel
    viewModel { RecordListDialogViewModel(get()) }
}