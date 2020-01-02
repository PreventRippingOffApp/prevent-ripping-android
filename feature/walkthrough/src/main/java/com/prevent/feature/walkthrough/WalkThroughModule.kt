package com.prevent.feature.walkthrough

import com.prevent.feature.walkthrough.info.PersonalInfoValidationLiveDataFactory
import com.prevent.feature.walkthrough.info.WalkThroughRegisterPersonalInfoViewModel
import com.prevent.feature.walkthrough.info.domain.PersonalInfoValidator
import com.prevent.feature.walkthrough.info.domain.PersonalInfoValidatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val walkthroughModule = module {
    factory { PersonalInfoValidatorImpl() as PersonalInfoValidator }
    factory { PersonalInfoValidationLiveDataFactory(get()) }

    viewModel { WalkThroughViewModel() }
    viewModel { WalkThroughRegisterPersonalInfoViewModel(get(), get()) }
}
