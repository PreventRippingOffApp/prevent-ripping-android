package com.prevent.feature.setting.domain

import kotlinx.coroutines.CoroutineScope

internal interface UpdateAlertLevelUsecase {
    fun execute(
        newLevel: Int,
        coroutineScope: CoroutineScope
    )
}
