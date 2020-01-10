package com.prevent.data.personal_data.impl

import com.prevent.data.personal_data.domain.PersonalInfoValidator
import com.prevent.data.personal_data.entity.PersonalDataEntity

internal class PersonalInfoValidatorImpl : PersonalInfoValidator {
    override fun validate(personalDataEntity: PersonalDataEntity): Boolean {
        return validateFirstName(personalDataEntity) &&
                validateLastName(personalDataEntity) &&
                validateAddress(personalDataEntity)
    }

    override fun validateFirstName(personalDataEntity: PersonalDataEntity): Boolean {
        return personalDataEntity.name.firstName.isNotEmpty()
    }

    override fun validateLastName(personalDataEntity: PersonalDataEntity): Boolean {
        return personalDataEntity.name.lastName.isNotEmpty()
    }

    override fun validateAddress(personalDataEntity: PersonalDataEntity): Boolean {
        return personalDataEntity.addressValueObject.address.isNotEmpty()
    }
}
