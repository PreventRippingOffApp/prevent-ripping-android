package com.prevent.feature.setting.infra

import com.prevent.alertmap_data.feature.domain.AlertLevelRepository
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity
import com.prevent.alertmap_data.feature.entity.valueobject.AlertlevelValueObject
import com.prevent.feature.setting.domain.UpdateAlertLevelUsecase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class UpdateAlertlevelUsecaseImpl(
    private val alertLevelRepository: AlertLevelRepository
) : UpdateAlertLevelUsecase {
    override fun execute(
        newLevel: Int,
        coroutineScope: CoroutineScope
    ) {
        coroutineScope.launch(Dispatchers.IO) {
            alertLevelRepository.storeAlertLevel(
                AlertLevelEntity(
                    0,
                    AlertlevelValueObject.create(newLevel)
                )
            )
        }
    }
}
