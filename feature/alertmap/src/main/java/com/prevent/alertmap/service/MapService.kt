package com.prevent.alertmap.service

import com.prevent.alertmap.entity.CurrentLocationEntity

internal interface MapService {

    fun ZoomInTolocation(locationEntity: CurrentLocationEntity)
}