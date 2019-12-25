package com.prevent.alertmap_data.feature.entity

import com.prevent.alertmap_data.feature.entity.valueobject.LatValueObject
import com.prevent.alertmap_data.feature.entity.valueobject.LonValueObject

data class LocationEntity(
    val int: Int,
    val latValueObject: LatValueObject,
    val lonValueObject: LonValueObject
) {
    companion object {
        fun default(): LocationEntity {
            return LocationEntity(
                0,
                LatValueObject(0.0),
                LonValueObject(0.0)
            )
        }
    }
}