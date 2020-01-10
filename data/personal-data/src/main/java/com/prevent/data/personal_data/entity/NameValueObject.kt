package com.prevent.data.personal_data.entity

import kotlinx.serialization.Serializable

@Serializable
data class NameValueObject(
    val firstName: String,
    val lastName: String
)
