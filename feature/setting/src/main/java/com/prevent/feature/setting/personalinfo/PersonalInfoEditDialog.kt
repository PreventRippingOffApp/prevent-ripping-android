package com.prevent.feature.setting.personalinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.prevent.feature.setting.databinding.DialogPersonalInfoEditBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PersonalInfoEditDialog : BottomSheetDialogFragment() {
    private val personalInfoEditViewModel: PersonalInfoEditViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogPersonalInfoEditBinding.inflate(
            layoutInflater,
            container,
            false
        )

        listOf(
            binding.dialogPersonalInfoEditFirstNameTextInputEditText,
            binding.dialogPersonalInfoEditLastNameTextTextInputEditText,
            binding.dialogPersonalInfoEditAddressTextInputEditText
        ).forEach {
            it.setOnClickListener {
                personalInfoEditViewModel.update(
                    binding.dialogPersonalInfoEditFirstNameTextInputEditText.text.toString(),
                    binding.dialogPersonalInfoEditLastNameTextTextInputEditText.text.toString(),
                    binding.dialogPersonalInfoEditAddressTextInputEditText.text.toString()
                )
            }
        }

        binding
            .dialogPersonalInfoEditSaveButton
            .setOnClickListener {
                this.dismiss()
            }

        personalInfoEditViewModel
            .personalInfoEditLiveData
            .observeForever {
                binding.viewEntity = it
            }

        return binding.root
    }
}
