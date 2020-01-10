package com.prevent.feature.setting.personalinfo

import com.prevent.data.personal_data.entity.PersonalDataEntity

internal fun PersonalDataEntity.convert(): PersonalInfoEditViewEntity {
    return PersonalInfoEditViewEntity(
        this.id,
        this.name.firstName,
        this.name.lastName,
        this.addressValueObject.address
    )
}

internal fun PersonalInfoEditViewEntity.clearErrorMessage(): PersonalInfoEditViewEntity {
    return this.copy(
        this.id,
        this.firstName,
        this.lastName,
        this.lastName,
        "",
        "",
        ""
    )
}
