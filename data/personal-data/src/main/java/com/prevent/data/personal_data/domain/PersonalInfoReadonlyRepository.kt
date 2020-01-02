package com.prevent.data.personal_data.domain

import com.prevent.data.personal_data.entity.PersonalDataEntity

interface PersonalInfoReadonlyRepository {
    fun loadPersonalInfo(): PersonalDataEntity
}
