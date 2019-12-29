package com.prevent.feature.setting

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import com.prevent.feature.setting.domain.UpdateAlertLevelUsecase
import kotlinx.coroutines.CoroutineScope

internal class AlertLevelLiveDataFactory(
    private val updateAlertLevelUsecase: UpdateAlertLevelUsecase,
    private val alertLevelReadonlyRepository: AlertLevelReadonlyRepository
) {
    fun create(
        coroutineScope: CoroutineScope
    ): AlertLevelLiveData {
        return AlertLevelLiveData(
            updateAlertLevelUsecase,
            alertLevelReadonlyRepository,
            coroutineScope
        )
    }
}
