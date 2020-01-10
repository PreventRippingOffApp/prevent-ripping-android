package com.prevent.feature.setting.personalinfo

import com.prevent.data.personal_data.domain.PersonalInfoReadonlyRepository
import com.prevent.data.personal_data.domain.PersonalInfoRepository
import com.prevent.data.personal_data.domain.PersonalInfoValidator
import kotlinx.coroutines.CoroutineScope

internal class PersonalInfoEditLiveDataFactory(
    private val personalInfoRepository: PersonalInfoRepository,
    private val personalInfoReadonlyRepository: PersonalInfoReadonlyRepository,
    private val personalInfoValidator: PersonalInfoValidator
) {
    fun create(
        coroutineScope: CoroutineScope
    ): PersonalInfoEditLiveData {
        return PersonalInfoEditLiveData(
            personalInfoRepository,
            personalInfoReadonlyRepository,
            personalInfoValidator,
            coroutineScope
        )
    }
}
