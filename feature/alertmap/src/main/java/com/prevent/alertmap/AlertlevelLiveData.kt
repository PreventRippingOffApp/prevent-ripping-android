package com.prevent.alertmap

import androidx.lifecycle.LiveData
import com.prevent.alertmap.entity.AlertLevelViewEntity
import com.prevent.alertmap.entity.convert
import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.entity.LocationEntity

internal class AlertlevelLiveData(
    alertLevelReadonlyRepository: AlertLevelReadonlyRepository
) : LiveData<AlertLevelViewEntity>() {
    init {
        val alertlevel = alertLevelReadonlyRepository.readAlertLevel(LocationEntity.default())
        postValue(
            alertlevel.convert()
        )
    }
}