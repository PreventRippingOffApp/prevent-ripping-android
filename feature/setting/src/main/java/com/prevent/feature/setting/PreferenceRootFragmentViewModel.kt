package com.prevent.feature.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

internal class PreferenceRootFragmentViewModel(
    alertLevelLiveDataFactory: AlertLevelLiveDataFactory
) : ViewModel() {

    val alertlevelLiveData: AlertLevelLiveData = alertLevelLiveDataFactory.create(viewModelScope)

    fun updateAlertLevel(newlevel: Int) {
        alertlevelLiveData.updateAlertLevel(newlevel)
    }
}
