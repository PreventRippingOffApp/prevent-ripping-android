package com.prevent.alertmap

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository
import kotlinx.coroutines.CoroutineScope

internal class AlertLevelLiveDataFactory(
    private val alertLevelReadonlyRepository: AlertLevelReadonlyRepository
) {
    fun create(
        coroutineScope: CoroutineScope
    ): AlertlevelLiveData {
        return AlertlevelLiveData(
            alertLevelReadonlyRepository,
            coroutineScope
        )
    }
}
