package com.prevent.feature.alert

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope

internal class MessageLiveData(
    val coroutineScope: CoroutineScope
) : LiveData<MessageListStatus>() {
    private var messageList = listOf(
        MessageType.AiMessage(
            "こんにちは",
            "11:45"
        ),
        MessageType.AiMessage(
            "困ったことがあったら連絡してね！",
            "14:19"
        ),
        MessageType.UserMessage(
            "おしゅし食べたい",
            "15:10"
        )
    )

    init {
        postValue(MessageListStatus.Loading)

        postValue(
            MessageListStatus.Success(
                messageList
            )
        )
    }

    fun sendMessage(sendMessageType: SendMessageType) {
        when (sendMessageType) {
            is SendMessageType.PlanMessage -> {
                messageList = messageList.toMutableList().apply {
                    this.add(
                        MessageType.UserMessage(
                            sendMessageType.message,
                            "12:34"
                        )
                    )
                }
                postValue(
                    MessageListStatus.Success(
                        messageList
                    )
                )
            }
        }
    }
}
