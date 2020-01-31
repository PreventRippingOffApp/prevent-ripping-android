package com.prevent.feature.alert

sealed class MessageType {
    data class AiMessage(
        val message: String,
        val sendDate: String
    ) : MessageType()

    data class UserMessage(
        val message: String,
        val sendDate: String
    ) : MessageType()
}