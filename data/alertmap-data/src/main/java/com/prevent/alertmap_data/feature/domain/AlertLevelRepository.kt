package com.prevent.alertmap_data.feature.domain

import com.prevent.alertmap_data.feature.entity.AlertLevelEntity

interface AlertLevelRepository {
    fun storeAlertLevel(alertLevelEntity: AlertLevelEntity)
}
