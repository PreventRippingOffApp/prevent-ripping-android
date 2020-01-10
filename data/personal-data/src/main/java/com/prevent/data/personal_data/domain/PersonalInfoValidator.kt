package com.prevent.data.personal_data.domain

import com.prevent.data.personal_data.entity.PersonalDataEntity

interface PersonalInfoValidator {
    fun validate(personalDataEntity: PersonalDataEntity): Boolean
    fun validateFirstName(personalDataEntity: PersonalDataEntity): Boolean
    fun validateLastName(personalDataEntity: PersonalDataEntity): Boolean
    fun validateAddress(personalDataEntity: PersonalDataEntity): Boolean
}
