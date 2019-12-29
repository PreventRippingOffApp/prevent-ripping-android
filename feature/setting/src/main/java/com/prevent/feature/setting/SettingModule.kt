package com.prevent.feature.setting

import com.prevent.feature.setting.domain.UpdateAlertLevelUsecase
import com.prevent.feature.setting.infra.UpdateAlertlevelUsecaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingModule = module {

    // LiveData
    factory { AlertLevelLiveDataFactory(get(), get()) }
    factory { UpdateAlertlevelUsecaseImpl(get()) as UpdateAlertLevelUsecase }

    viewModel { PreferenceRootFragmentViewModel(get()) }
}
