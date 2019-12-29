package com.prevent.feature.setting

import androidx.lifecycle.LiveData
import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.alertmap_data.feature.entity.LocationEntity
import com.prevent.feature.setting.domain.UpdateAlertLevelUsecase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class AlertLevelLiveData(
    private val updateAlertLevelUsecase: UpdateAlertLevelUsecase,
    private val alertLevelReadonlyRepository: AlertLevelReadonlyRepository,
    private val coroutineScope: CoroutineScope
) : LiveData<Int>() {
    init {
        refreshAlertLevel()
    }

    fun updateAlertLevel(newLevel: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            updateAlertLevelUsecase.execute(newLevel, coroutineScope)
        }
    }

    private fun refreshAlertLevel() {
        coroutineScope.launch(Dispatchers.IO) {
            postValue(
                alertLevelReadonlyRepository.readAlertLevel(LocationEntity.default()).alertlevelValueObject.value
            )
        }
    }
}
