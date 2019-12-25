package com.prevent.alertmap_data.feature.domain

import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.LocationEntity

interface AlertLevelReadonlyRepository {
    fun readAlertLevel(
        locationEntity: LocationEntity
    ): AlertLevelEntity
}
