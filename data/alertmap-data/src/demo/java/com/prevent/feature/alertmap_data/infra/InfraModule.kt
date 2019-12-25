package com.prevent.feature.alertmap_data.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val infraModule = module {
    factory { AlertLevelPreference(androidApplication()) }

    // Repository
    factory { AlertLevelReadonlyRepositoryImpl(get()) as AlertLevelReadonlyRepository }
    factory { AlertLevelRepositoryImpl(get()) as AlertLevelRepository }
}
