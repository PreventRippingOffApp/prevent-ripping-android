package com.prevent.alertmap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prevent.alertmap.entity.CurrentLocationEntity
import com.prevent.alertmap.usecase.FetchCurrentLocationUsecase

internal class AlertMapViewModel(
    private val featchCurrentLocationUsecase: FetchCurrentLocationUsecase,
    private val alertLevelLiveDataFactory: AlertLevelLiveDataFactory
) : ViewModel() {
    val currentLocationLiveData: LiveData<CurrentLocationEntity> = MutableLiveData(
        featchCurrentLocationUsecase.execute()
    )

    val alertLevelLiveData: AlertlevelLiveData =
        alertLevelLiveDataFactory.create(viewModelScope)

    fun refreshAlertLevel() {
        alertLevelLiveData.refresh()
    }
}
