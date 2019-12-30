package com.prevent.feature.walkthrough.info

internal data class PersonalInfoValidationViewEntity(
    val validate: Boolean,
    val firstNameErrorMessage: String,
    val lastNameErrorMessage: String,
    val addressErrorMessage: String
)
