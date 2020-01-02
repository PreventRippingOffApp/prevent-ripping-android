package com.prevent.feature.walkthrough.info

import com.prevent.feature.walkthrough.info.domain.PersonalInfoValidator

internal class PersonalInfoValidationLiveDataFactory(
    private val personalInfoValidator: PersonalInfoValidator
) {
    fun create(): PersonalInfoValidationLiveData {
        return PersonalInfoValidationLiveData(
            personalInfoValidator
        )
    }
}
