package com.prevent.feature.walkthrough.info.domain

class PersonalInfoValidatorImpl : PersonalInfoValidator {
    override fun firstNameValidate(firstName: String): Boolean {
        return firstName.isNotEmpty()
    }

    override fun lastNameValidate(lastname: String): Boolean {
        return lastname.isNotEmpty()
    }

    override fun addressValidate(address: String): Boolean {
        return address.isNotEmpty()
    }
}
