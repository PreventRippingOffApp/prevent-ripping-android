package com.prevent.alertmap

import androidx.fragment.app.Fragment
import com.prevent.alertmap.service.MapService
import com.prevent.alertmap.service.MapServiceImpl
import com.prevent.alertmap.usecase.FetchCurrentLocationUsecase
import com.prevent.alertmap.usecase.impl.FetchCurrentLocationUsecaseImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val alertMapModule = module {
    factory { FetchCurrentLocationUsecaseImpl(androidApplication()) as FetchCurrentLocationUsecase }

    factory { (fragment: Fragment) -> MapServiceImpl(fragment) as MapService }
    factory { AlertLevelLiveDataFactory(get()) }

    viewModel { AlertMapViewModel(get(), get()) }
}