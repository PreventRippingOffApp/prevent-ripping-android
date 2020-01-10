package com.prevent.feature.walkthrough.info

import androidx.lifecycle.LiveData
import com.prevent.data.personal_data.domain.PersonalInfoValidator
import com.prevent.data.personal_data.entity.AddressValueObject
import com.prevent.data.personal_data.entity.NameValueObject
import com.prevent.data.personal_data.entity.PersonalDataEntity

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
        val personalDataEntity =
            PersonalDataEntity(0, NameValueObject(firstName, lastName), AddressValueObject(address))

        val firstNameValidateResult = personalInfoValidator.validateFirstName(personalDataEntity)
        val lastNameValidateResult = personalInfoValidator.validateLastName(personalDataEntity)
        val addressValidateResult = personalInfoValidator.validateAddress(personalDataEntity)

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
