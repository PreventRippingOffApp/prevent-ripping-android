package com.prevent.feature.setting

import com.prevent.feature.setting.domain.BiometricService
import com.prevent.feature.setting.domain.BiometricServiceImpl
import com.prevent.feature.setting.domain.ShowAboutDeveloperUsecase
import com.prevent.feature.setting.infra.ShowAboutDeveloperUsecaseImpl
import com.prevent.feature.setting.personalinfo.PersonalInfoEditLiveDataFactory
import com.prevent.feature.setting.personalinfo.PersonalInfoEditViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingModule = module {
    factory { ShowAboutDeveloperUsecaseImpl(androidContext()) as ShowAboutDeveloperUsecase }
    factory { BiometricServiceImpl(androidContext()) as BiometricService }

    factory { PersonalInfoEditLiveDataFactory(get(), get(), get()) }

    factory { PersonalInfoEditAuthLiveDataFactory(get()) }

    viewModel { PersonalInfoEditViewModel(get()) }
    viewModel { PreferenceRootFragmentViewModel(get(), get()) }
}
