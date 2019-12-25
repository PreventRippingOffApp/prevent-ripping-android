package com.prevent.feature.alertmap_data.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity

internal class AlertLevelRepositoryImpl(
    private val alertLevelPreference: AlertLevelPreference
) :
    AlertLevelRepository {
    override fun storeAlertLevel(alertLevelEntity: AlertLevelEntity) {
        alertLevelPreference.storeData(alertLevelEntity)
    }
}