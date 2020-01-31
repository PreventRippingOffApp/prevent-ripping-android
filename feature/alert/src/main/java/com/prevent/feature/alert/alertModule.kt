package com.prevent.feature.alert

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val alertModule = module {
    viewModel { ChatFragmentViewModel(get()) }
    factory { MessageLiveDataFactory() }
}