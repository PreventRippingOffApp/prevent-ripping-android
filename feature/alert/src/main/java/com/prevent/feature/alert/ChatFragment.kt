package com.prevent.feature.alert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nagoya.kuu.feature.alert.databinding.ChatFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatFragment : Fragment() {

    private val viewModel: ChatFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = ChatFragmentBinding
            .inflate(
                layoutInflater,
                container,
                false
            )

        binding.sendButton.setOnClickListener {
            viewModel.sendMessage(binding.messageEditText.text.toString())
            binding.messageEditText.text.clear()
        }

        val chatMessageAdapter = ChatMessageAdapter(requireContext())
        binding.chatMessageRecyclerView.adapter = chatMessageAdapter

        viewModel
            .message
            .observeForever {
                when (it) {
                    MessageListStatus.Loading -> TODO()
                    is MessageListStatus.Success -> {
                        chatMessageAdapter.submitList(it.value)
                        binding.chatMessageRecyclerView.smoothScrollToPosition(chatMessageAdapter.itemCount - 1)
                    }
                    is MessageListStatus.Failed -> TODO()
                }
            }

        return binding.root
    }
}
