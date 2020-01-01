package com.prevent.feature.alertmap_data.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.LocationEntity
import com.prevent.util.loadData

internal class AlertLevelReadonlyRepositoryImpl(
    private val alertLevelPreference: AlertLevelPreference
) :
    AlertLevelReadonlyRepository {

    override fun readAlertLevel(locationEntity: LocationEntity): AlertLevelEntity {
        return alertLevelPreference.loadData() ?: AlertLevelEntity.default()
    }
}
