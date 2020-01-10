package com.prevent.feature.setting.personalinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

internal class PersonalInfoEditViewModel(
    private val personalInfoEditLiveDataFactory: PersonalInfoEditLiveDataFactory
) : ViewModel() {
    private var _personalInfoEditMutableLiveData: PersonalInfoEditLiveData =
        personalInfoEditLiveDataFactory.create(viewModelScope)
    val personalInfoEditLiveData: LiveData<PersonalInfoEditViewEntity> =
        _personalInfoEditMutableLiveData

    fun update(
        firstName: String,
        lastName: String,
        address: String
    ) {
        _personalInfoEditMutableLiveData.update(
            firstName,
            lastName,
            address
        )
    }
}
