package com.prevent.data.personal_data.impl

import android.content.Context
import com.prevent.data.personal_data.domain.PersonalInfoReadonlyRepository
import com.prevent.data.personal_data.domain.PersonalInfoRepository
import com.prevent.data.personal_data.entity.PersonalDataEntity
import com.prevent.util.PreferenceContainer

internal class PersonalInfoRepositoryImpl(
    context: Context
) : PersonalInfoRepository, PersonalInfoReadonlyRepository {

    private val personalDataPreference: PreferenceContainer<PersonalDataEntity> =
        PreferenceContainer.of(
            context,
            "personal_data_entity_preference",
            PersonalDataEntity::class
        )

    override fun storePersonalInfo(personalDataEntity: PersonalDataEntity) {
        personalDataPreference.storeData(personalDataEntity)
    }

    override fun loadPersonalInfo(): PersonalDataEntity {
        return personalDataPreference.loadDataBySerializer(
            PersonalDataEntity.serializer(),
            PersonalDataEntity.default()
        )
    }
}
