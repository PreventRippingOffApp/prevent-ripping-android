package com.prevent.feature.setting.personalinfo

data class PersonalInfoEditViewEntity(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val address: String,
    val firstNameErrorMessage: String? = null,
    val lastNameErrorMessage: String? = null,
    val addressErrorMessage: String? = null
)
