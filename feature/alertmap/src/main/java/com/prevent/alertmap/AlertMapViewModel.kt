package com.prevent.alertmap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prevent.alertmap.entity.CurrentLocationEntity
import com.prevent.alertmap.usecase.FetchCurrentLocationUsecase

internal class AlertMapViewModel(
    private val featchCurrentLocationUsecase: FetchCurrentLocationUsecase
) : ViewModel() {
    private val currentLocationLiveData: LiveData<CurrentLocationEntity> = MutableLiveData(
        featchCurrentLocationUsecase.execute()
    )
}