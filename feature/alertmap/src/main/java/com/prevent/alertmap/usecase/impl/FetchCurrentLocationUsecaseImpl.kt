package com.prevent.alertmap.usecase.impl

import android.annotation.SuppressLint
import android.content.Context
import android.location.Criteria
import android.location.LocationManager
import com.prevent.alertmap.entity.CurrentLocationEntity
import com.prevent.alertmap.entity.LatLonEntity
import com.prevent.alertmap.entity.value.LatValue
import com.prevent.alertmap.entity.value.LonValue
import com.prevent.alertmap.usecase.FetchCurrentLocationUsecase

class FetchCurrentLocationUsecaseImpl(
    private val context: Context
) :
    FetchCurrentLocationUsecase {
    @SuppressLint("MissingPermission")
    override fun execute(): CurrentLocationEntity {
        val locationManager =
            context.getSystemService(LocationManager::class.java) ?: throw NullPointerException()

        val criteria = Criteria()
            .apply {
                this.accuracy = Criteria.ACCURACY_COARSE
            }

        val provider = locationManager.getProviders(criteria, false).first()
        val lastLocation =
            locationManager.getLastKnownLocation(provider) ?: throw NullPointerException()

        val lat = LatValue(lastLocation.latitude)
        val lon = LonValue(lastLocation.longitude)

        return CurrentLocationEntity(0, LatLonEntity(lat, lon))
    }
}