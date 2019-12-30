package com.prevent.data.personal_data.impl

import android.content.Context
import com.prevent.data.personal_data.domain.PersonalInfoReadonlyRepository
import com.prevent.data.personal_data.domain.PersonalInfoRepository
import com.prevent.data.personal_data.entity.PersonalDataEntity
import com.prevent.util.loadData
import com.prevent.util.storeData

internal class PersonalInfoRepositoryImpl(
    context: Context
) : PersonalInfoRepository, PersonalInfoReadonlyRepository {

    private val personalDataPreference: PersonalDataPreference = PersonalDataPreference(context)

    override fun storePersonalInfo(personalDataEntity: PersonalDataEntity) {
        personalDataPreference.storeData(personalDataEntity)
    }

    override fun loadPersonalInfo(): PersonalDataEntity {
        return personalDataPreference.loadData(PersonalDataEntity.default())
    }
}
