package com.prevent.feature.alertmap_data.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.LocationEntity
import com.prevent.alertmap_data.feature.entity.valueobject.AlertlevelValueObject

internal class AlertLevelRepositoryImpl : AlertLevelReadonlyRepository, AlertLevelRepository {
    override fun readAlertLevel(locationEntity: LocationEntity): AlertLevelEntity {
        //TODO after implementation get from remote APi Call
        return AlertLevelEntity(0, AlertlevelValueObject.create(30))
    }

    override fun storeAlertLevel(alertLevelEntity: AlertLevelEntity) {
        // Noting doing on production flavor
        //TODO after implementation logging process
    }

}