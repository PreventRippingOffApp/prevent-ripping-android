package com.prevent.data.personal_data.domain

import com.prevent.data.personal_data.entity.PersonalDataEntity

interface PersonalInfoRepository {
    fun storePersonalInfo(personalDataEntity: PersonalDataEntity)
}
