package com.prevent.feature.alertmap_data.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import org.koin.dsl.module

val infraModule = module {

    // repository
    factory { AlertLevelRepositoryImpl() as AlertLevelRepository }
    factory { AlertLevelRepositoryImpl() as AlertLevelReadonlyRepository }
}