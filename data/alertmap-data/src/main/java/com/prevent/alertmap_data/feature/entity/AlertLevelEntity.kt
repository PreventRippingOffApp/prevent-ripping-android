package com.prevent.alertmap_data.feature.entity

import com.prevent.alertmap_data.feature.entity.valueobject.AlertlevelValueObject

data class AlertLevelEntity(
    val id: Int,
    val alertlevelValueObject: AlertlevelValueObject
) {
    companion object {
        fun default(id: Int = 0): AlertLevelEntity {
            return AlertLevelEntity(
                id,
                AlertlevelValueObject.default()
            )
        }
    }
}
