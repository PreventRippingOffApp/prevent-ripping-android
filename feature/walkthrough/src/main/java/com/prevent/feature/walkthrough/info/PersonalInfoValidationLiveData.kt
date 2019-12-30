package com.prevent.feature.walkthrough.info

import androidx.lifecycle.LiveData
import com.prevent.feature.walkthrough.info.domain.PersonalInfoValidator

internal class PersonalInfoValidationLiveData(
    private val personalInfoValidator: PersonalInfoValidator
) : LiveData<PersonalInfoValidationViewEntity>() {
    init {
        value = PersonalInfoValidationViewEntity(
            false,
            "",
            "",
            ""
        )
    }

    fun updatePersonalInfo(
        firstName: String,
        lastName: String,
        address: String
    ) {
        val firstNameValidateResult = personalInfoValidator.firstNameValidate(firstName)
        val lastNameValidateResult = personalInfoValidator.lastNameValidate(lastName)
        val addressValidateResult = personalInfoValidator.addressValidate(address)

        val firstNameErrorMessage = if (firstNameValidateResult) {
            ""
        } else {
            "苗字を入力してください"
        }
        val lastNameErrorMessage = if (lastNameValidateResult) {
            ""
        } else {
            "名前を入力してください"
        }
        val addressErrorMessage = if (addressValidateResult) {
            ""
        } else {
            "住所を入力してください"
        }

        value = PersonalInfoValidationViewEntity(
            firstNameValidateResult && lastNameValidateResult && addressValidateResult,
            firstNameErrorMessage,
            lastNameErrorMessage,
            addressErrorMessage
        )
    }
}
