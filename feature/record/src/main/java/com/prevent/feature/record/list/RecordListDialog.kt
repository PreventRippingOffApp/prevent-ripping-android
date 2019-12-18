package com.prevent.feature.record.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.prevent.feature.record.databinding.DialogRecordListBinding

class RecordListDialog : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogRecordListBinding
            .inflate(
                layoutInflater,
                container,
                false
            )

        return binding.root
    }
}