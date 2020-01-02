package com.prevent.feature.alertmap_data.infra

import android.content.Context
import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.LocationEntity
import com.prevent.util.PreferenceContainer

internal class AlertLevelRepositoryImpl(
    private val context: Context
) : AlertLevelRepository, AlertLevelReadonlyRepository {

    private val preference =
        PreferenceContainer.of(context, "alert_level_preference", AlertLevelEntity::class)

    override fun storeAlertLevel(alertLevelEntity: AlertLevelEntity) {
        preference.storeData(alertLevelEntity)
    }

    override fun readAlertLevel(locationEntity: LocationEntity): AlertLevelEntity {
        return preference.loadData(AlertLevelEntity.default(0))
    }
}
