package com.prevent.feature.setting

import com.prevent.feature.setting.domain.BiometricService
import kotlinx.coroutines.CoroutineScope

internal class PersonalInfoEditAuthLiveDataFactory(
    private val biometricService: BiometricService
) {
    fun create(
        coroutineScope: CoroutineScope
    ): PersonalInfoEditAuthLiveData {
        return PersonalInfoEditAuthLiveData(
            biometricService,
            coroutineScope
        )
    }
}
