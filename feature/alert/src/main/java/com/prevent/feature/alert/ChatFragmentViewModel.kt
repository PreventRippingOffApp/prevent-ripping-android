package com.prevent.feature.alert

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


internal class ChatFragmentViewModel(
    private val messageLiveDataFactory: MessageLiveDataFactory
) : ViewModel() {
    private val messageLiveData: MessageLiveData = messageLiveDataFactory.create(viewModelScope)
    val message: LiveData<MessageListStatus> = messageLiveData

    fun sendMessage(message: String) {
        messageLiveData.sendMessage(SendMessageType.PlanMessage(message))
    }
}