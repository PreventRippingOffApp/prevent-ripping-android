package com.prevent.feature.setting.domain

sealed class BiometricState {
    object Success : BiometricState()
    data class Failed(val message: String) : BiometricState()
    object Denied : BiometricState()
    // Never regist biometric info
    object NoEnrolled : BiometricState()

    // maybe unreachable
    object unknow : BiometricState()

    // user hardware don't have biometric device
    object NoHardware : BiometricState()

    object HardwareEnable : BiometricState()
}
