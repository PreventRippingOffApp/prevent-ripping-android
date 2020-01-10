package com.prevent.feature.setting.state

sealed class PersonalInfoEditAuthState {
    object success : PersonalInfoEditAuthState()
    data class failed(val message: String? = null) : PersonalInfoEditAuthState()
}
