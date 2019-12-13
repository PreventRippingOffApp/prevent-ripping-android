package com.prevent.alertmap

import com.prevent.alertmap.usecase.FetchCurrentLocationUsecase
import com.prevent.alertmap.usecase.impl.FetchCurrentLocationUsecaseImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val alertMapModule = module {
    factory { FetchCurrentLocationUsecaseImpl(androidApplication()) as FetchCurrentLocationUsecase }

    viewModel { AlertMapViewModel(get()) }
}