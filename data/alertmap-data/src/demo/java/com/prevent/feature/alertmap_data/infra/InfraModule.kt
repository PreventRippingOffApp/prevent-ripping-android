package com.prevent.feature.alertmap_data.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val infraModule = module {
    // Repository
    factory { AlertLevelRepositoryImpl(androidApplication()) as AlertLevelReadonlyRepository }
    factory { AlertLevelRepositoryImpl(androidApplication()) as AlertLevelRepository }
}
