package com.prevent.feature.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nagoya.kuu.feature.alert.databinding.PlanAiChatMessageItemBinding

internal class ChatPlanAiMessageViewHolder private constructor(
    private val binding: PlanAiChatMessageItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(
            context: Context,
            container: ViewGroup
        ): ChatPlanAiMessageViewHolder {
            return ChatPlanAiMessageViewHolder(
                PlanAiChatMessageItemBinding.inflate(
                    LayoutInflater.from(context),
                    container,
                    false
                )
            )
        }
    }

    fun bindTo(message:MessageType.AiMessage){
        binding.message = message
    }
}