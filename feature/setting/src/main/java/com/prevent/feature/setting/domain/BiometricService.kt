package com.prevent.feature.setting.domain

import androidx.fragment.app.Fragment

interface BiometricService {
    suspend fun auth(fragment: Fragment): BiometricState
}
