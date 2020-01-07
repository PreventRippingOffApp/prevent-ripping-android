package com.prevent.feature.walkthrough.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.prevent.feature.walkthrough.databinding.FragmentWalkthroughRegisterPersonalInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class WalkThroughRegisterPersonalInfoFragment(
    private val nextPage: (() -> Unit)
) : Fragment() {
    val walkThroughRegisterPersonalInfoViewModel: WalkThroughRegisterPersonalInfoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentWalkthroughRegisterPersonalInfoBinding.inflate(
            layoutInflater,
            container,
            false
        )

        walkThroughRegisterPersonalInfoViewModel
            .personalInfoValidationLiveData
            .observeForever {
                binding.viewEntity = it
            }

        listOf(
            binding.fragmentWalkthroughRegisterPersonalInfoFirstNameTextInputEditText,
            binding.fragmentWalkthroughRegisterPersonalInfoLastNameTextInputEditText,
            binding.fragmentWalkthroughRegisterPersonalInfoAddressTextInputEditText
        ).forEach {
            it.doAfterTextChanged {
                walkThroughRegisterPersonalInfoViewModel
                    .formUpdate(
                        binding.fragmentWalkthroughRegisterPersonalInfoFirstNameTextInputEditText.text.toString(),
                        binding.fragmentWalkthroughRegisterPersonalInfoLastNameTextInputEditText.text.toString(),
                        binding.fragmentWalkthroughRegisterPersonalInfoAddressTextInputEditText.text.toString()
                    )
            }
        }

        binding
            .fragmentWalkthroughRegisterPersonalInfoSaveMaterialButton
            .setOnClickListener {
                walkThroughRegisterPersonalInfoViewModel
                    .savePersonalInfo(
                        binding.fragmentWalkthroughRegisterPersonalInfoFirstNameTextInputEditText.text.toString(),
                        binding.fragmentWalkthroughRegisterPersonalInfoLastNameTextInputEditText.text.toString(),
                        binding.fragmentWalkthroughRegisterPersonalInfoAddressTextInputEditText.text.toString()
                    )

                nextPage()
            }

        return binding.root
    }
}
