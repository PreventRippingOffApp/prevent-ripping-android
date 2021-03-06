package com.prevent.feature.record.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.prevent.feature.record.databinding.DialogRecordListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecordListDialog : BottomSheetDialogFragment() {

    private val recordListDialogViewModel: RecordListDialogViewModel by viewModel()

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

        val recordListAdapter = RecordListAdapter(requireContext())

        binding.dialogRecordListRecordLogRecyclerView.adapter = recordListAdapter

        recordListDialogViewModel
            .recordListLiveData
            .observeForever {
                recordListAdapter.submitList(it)
                binding.dialogRecordListEmptyRecordMessageTextView.visibility =
                    if (it.isEmpty()) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
            }

        binding
            .dialogRecordListClearAllRecordImageButton
            .setOnClickListener {
                recordListDialogViewModel.clearRecordData()
            }

        return binding.root
    }
}
