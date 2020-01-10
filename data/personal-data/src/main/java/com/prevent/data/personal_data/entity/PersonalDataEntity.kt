package com.prevent.data.personal_data.entity

import kotlinx.serialization.Serializable

@Serializable
data class PersonalDataEntity(
    val id: Int,
    val name: NameValueObject,
    val addressValueObject: AddressValueObject
) {
    companion object {
        fun default(): PersonalDataEntity {
            return PersonalDataEntity(
                0,
                NameValueObject(
                    "",
                    ""
                ),
                AddressValueObject(
                    ""
                )
            )
        }
    }
}
