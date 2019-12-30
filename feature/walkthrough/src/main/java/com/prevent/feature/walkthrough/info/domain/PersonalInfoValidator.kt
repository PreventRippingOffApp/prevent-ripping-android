package com.prevent.feature.walkthrough.info.domain

internal interface PersonalInfoValidator {
    fun firstNameValidate(firstName: String): Boolean
    fun lastNameValidate(lastname: String): Boolean
    fun addressValidate(address: String): Boolean
}
