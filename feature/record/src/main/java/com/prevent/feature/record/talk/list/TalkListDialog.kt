package com.prevent.feature.record.talk.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.prevent.feature.record.databinding.DialogTalkListBinding

class TalkListDialog : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogTalkListBinding.inflate(
            layoutInflater,
            container,
            false
        )

        return binding.root
    }
}