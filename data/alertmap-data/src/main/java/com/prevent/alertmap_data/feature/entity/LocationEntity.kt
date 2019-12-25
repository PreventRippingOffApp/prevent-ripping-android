package com.prevent.alertmap_data.feature.entity

import com.prevent.alertmap_data.feature.entity.valueobject.LatValueObject
import com.prevent.alertmap_data.feature.entity.valueobject.LonValueObject

data class LocationEntity(
    val int: Int,
    val latValueObject: LatValueObject,
    val lonValueObject: LonValueObject
)