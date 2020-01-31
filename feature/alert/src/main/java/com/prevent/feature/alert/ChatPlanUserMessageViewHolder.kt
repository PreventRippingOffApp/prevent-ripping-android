package com.prevent.feature.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nagoya.kuu.feature.alert.databinding.PlanUserChatMessageItemBinding

internal class ChatPlanUserMessageViewHolder private constructor(
    val binding: PlanUserChatMessageItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            context: Context,
            container: ViewGroup
        ): ChatPlanUserMessageViewHolder {
            return ChatPlanUserMessageViewHolder(
                PlanUserChatMessageItemBinding.inflate(
                    LayoutInflater.from(context),
                    container,
                    false
                )
            )
        }
    }

    fun bindTo(message: MessageType.UserMessage) {
        binding.message = message
    }
}
