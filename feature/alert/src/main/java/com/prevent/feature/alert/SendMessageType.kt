package com.prevent.feature.alert

sealed class SendMessageType {
    data class PlanMessage(val message: String) : SendMessageType()
}
