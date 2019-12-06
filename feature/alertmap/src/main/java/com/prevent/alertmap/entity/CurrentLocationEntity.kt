package com.prevent.alertmap.entity

import com.prevent.alertmap.entity.value.LatValue
import com.prevent.alertmap.entity.value.LonValue

data class LatLonEntity(
    val lat: LatValue,
    val lon: LonValue
)

data class CurrentLocationEntity(
    val id: Int,
    val location: LatLonEntity
)