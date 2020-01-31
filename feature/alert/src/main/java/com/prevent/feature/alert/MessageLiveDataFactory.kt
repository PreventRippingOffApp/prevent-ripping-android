package com.prevent.feature.alert

import kotlinx.coroutines.CoroutineScope

internal class MessageLiveDataFactory {
    fun create(
        coroutineScope: CoroutineScope
    ): MessageLiveData {
        return MessageLiveData(
            coroutineScope
        )
    }
}
