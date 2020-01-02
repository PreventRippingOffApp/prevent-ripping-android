package com.prevent.feature.walkthrough.info

import androidx.lifecycle.ViewModel
import com.prevent.data.personal_data.domain.PersonalInfoRepository
import com.prevent.data.personal_data.entity.AddressValueObject
import com.prevent.data.personal_data.entity.NameValueObject
import com.prevent.data.personal_data.entity.PersonalDataEntity

internal class WalkThroughRegisterPersonalInfoViewModel(
    private val personalInfoValidationLiveDataFactory: PersonalInfoValidationLiveDataFactory,
    private val personalInfoRepository: PersonalInfoRepository
) : ViewModel() {

    val personalInfoValidationLiveData: PersonalInfoValidationLiveData =
        personalInfoValidationLiveDataFactory.create()

    fun formUpdate(
        firstName: String,
        lastName: String,
        address: String
    ) {
        personalInfoValidationLiveData.updatePersonalInfo(
            firstName,
            lastName,
            address
        )
    }

    fun savePersonalInfo(
        firstName: String,
        lastName: String,
        address: String
    ) {
        personalInfoRepository.storePersonalInfo(
            PersonalDataEntity(
                0,
                NameValueObject(
                    firstName,
                    lastName
                ),
                AddressValueObject(
                    address
                )
            )
        )
    }
}
