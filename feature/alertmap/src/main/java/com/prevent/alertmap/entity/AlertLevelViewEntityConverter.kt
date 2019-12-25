package com.prevent.alertmap.entity

import com.prevent.alertmap.entity.value.AlertLevelViewObject
import com.prevent.alertmap_data.feature.entity.AlertLevelEntity

internal fun AlertLevelEntity.convert(): AlertLevelViewEntity {
    return AlertLevelViewEntity(
        this.id,
        AlertLevelViewObject.create(
            this.alertlevelValueObject.value
        )
    )
}