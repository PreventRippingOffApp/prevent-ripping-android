package com.prevent.feature.setting

import com.prevent.feature.setting.domain.ShowAboutDeveloperUsecase
import com.prevent.feature.setting.infra.ShowAboutDeveloperUsecaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingModule = module {
    factory { ShowAboutDeveloperUsecaseImpl(androidContext()) as ShowAboutDeveloperUsecase }
    viewModel {
        PreferenceRootFragmentViewModel(
            get()
        )
    }
}
