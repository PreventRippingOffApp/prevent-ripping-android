package com.prevent.alertmap

import com.prevent.alertmap_data.feature.domain.AlertLevelReadonlyRepository

internal class AlertLevelLiveDataFactory(
    private val alertLevelReadonlyRepository: AlertLevelReadonlyRepository
) {
    fun create(): AlertlevelLiveData {
        return AlertlevelLiveData(
            alertLevelReadonlyRepository
        )
    }
}