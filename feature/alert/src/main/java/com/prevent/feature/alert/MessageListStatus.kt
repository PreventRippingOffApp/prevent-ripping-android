package com.prevent.feature.alert

sealed class MessageListStatus {
    object Loading : MessageListStatus()
    data class Success(val value: List<MessageType>) : MessageListStatus()
    data class Failed(val errorMessage: String) : MessageListStatus()
}