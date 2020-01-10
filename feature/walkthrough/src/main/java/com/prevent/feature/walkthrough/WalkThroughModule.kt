package com.prevent.feature.walkthrough

import com.prevent.feature.walkthrough.info.PersonalInfoValidationLiveDataFactory
import com.prevent.feature.walkthrough.info.WalkThroughRegisterPersonalInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val walkthroughModule = module {
    factory { PersonalInfoValidationLiveDataFactory(get()) }

    viewModel { WalkThroughViewModel() }
    viewModel { WalkThroughRegisterPersonalInfoViewModel(get(), get()) }
}
