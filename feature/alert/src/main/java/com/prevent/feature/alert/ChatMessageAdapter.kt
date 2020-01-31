package com.prevent.feature.alert

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class ChatMessageAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messageList: List<MessageType> = emptyList()

    fun submitList(newList: List<MessageType>) {
        messageList = newList
        this.notifyDataSetChanged()
    }

    companion object {
        val PlanAiMessage = 0
        val PlanUserMessage = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PlanAiMessage -> ChatPlanAiMessageViewHolder.create(context, parent)
            PlanUserMessage -> ChatPlanUserMessageViewHolder.create(context, parent)
            else -> ChatPlanAiMessageViewHolder.create(context, parent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (messageList.elementAt(position)) {
            is MessageType.UserMessage -> PlanUserMessage
            is MessageType.AiMessage -> PlanAiMessage
        }
    }

    override fun getItemCount(): Int {
        return messageList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = messageList.elementAt(position)
        when (holder) {
            is ChatPlanUserMessageViewHolder -> holder.bindTo(item as MessageType.UserMessage)
            is ChatPlanAiMessageViewHolder -> holder.bindTo(item as MessageType.AiMessage)
        }
    }
}
