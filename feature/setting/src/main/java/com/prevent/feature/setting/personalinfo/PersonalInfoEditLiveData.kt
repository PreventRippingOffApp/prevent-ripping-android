package com.prevent.feature.setting.personalinfo

import androidx.lifecycle.LiveData
import com.prevent.data.personal_data.domain.PersonalInfoReadonlyRepository
import com.prevent.data.personal_data.domain.PersonalInfoRepository
import com.prevent.data.personal_data.domain.PersonalInfoValidator
import com.prevent.data.personal_data.entity.AddressValueObject
import com.prevent.data.personal_data.entity.NameValueObject
import com.prevent.data.personal_data.entity.PersonalDataEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

internal class PersonalInfoEditLiveData(
    private val personalInfoRepository: PersonalInfoRepository,
    private val personalInfoReadonlyRepository: PersonalInfoReadonlyRepository,
    private val personalInfoValidator: PersonalInfoValidator,
    private val coroutineScope: CoroutineScope
) : LiveData<PersonalInfoEditViewEntity>() {
    init {
        refreshData()
    }

    fun update(
        firstName: String,
        lastName: String,
        address: String
    ) {
        val personalInfoEntity =
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

        val firstNameErrorMessage =
            if (personalInfoValidator.validateFirstName(personalInfoEntity)) {
                ""
            } else {
                "苗字が不正です。"
            }

        val lastNameErrorMessage =
            if (personalInfoValidator.validateLastName(personalInfoEntity)) {
                ""
            } else {
                "名前が不正です"
            }

        val addressErrorMessage =
            if (personalInfoValidator.validateAddress(personalInfoEntity)) {
                ""
            } else {
                "住所が不正です"
            }

        try {
            personalInfoRepository.storePersonalInfo(personalInfoEntity)
        } catch (e: Exception) {
            refreshData()
        }

        postValue(
            personalInfoEntity
                .convert()
                .copy(
                    firstNameErrorMessage = firstNameErrorMessage,
                    lastNameErrorMessage = lastNameErrorMessage,
                    addressErrorMessage = addressErrorMessage
                )
        )
    }

    private fun refreshData() {
        try {
            coroutineScope.launch {
                postValue(
                    personalInfoReadonlyRepository.loadPersonalInfo().convert()
                )
            }
        } catch (e: Exception) {
            update(
                "",
                "",
                ""
            )
        }
    }
}
