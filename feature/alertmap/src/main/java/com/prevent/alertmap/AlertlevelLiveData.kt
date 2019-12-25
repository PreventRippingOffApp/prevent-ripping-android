package com.prevent.alertmap

import androidx.lifecycle.LiveData
import com.prevent.alertmap.entity.AlertLevelViewEntity
import com.prevent.alertmap.entity.convert
import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.entity.LocationEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class AlertlevelLiveData(
    private val alertLevelReadonlyRepository: AlertLevelReadonlyRepository,
    private val coroutineScope: CoroutineScope
) : LiveData<AlertLevelViewEntity>() {

    private fun refreshAlertLevel() {
        coroutineScope.launch(Dispatchers.IO) {
            val alertlevel = alertLevelReadonlyRepository.readAlertLevel(LocationEntity.default())
            postValue(
                alertlevel.convert()
            )
        }
    }

    fun refresh() {
        refreshAlertLevel()
    }
}