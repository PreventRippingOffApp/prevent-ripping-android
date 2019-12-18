package com.prevent.data.recorddata.impl

import com.prevent.data.recorddata.model.RecordDataEntity
import com.prevent.data.recorddata.model.valueobject.AudioFilePathValueObject
import com.prevent.data.recorddata.model.valueobject.RecordDateValueObject
import java.util.Date

internal fun RecordDataEntity.convertTo(): RecordDataModel {
    return RecordDataModel(
        this.id,
        this.audioFilePath.value,
        this.recordDate.date.time
    )
}

internal fun RecordDataModel.convertTo(): RecordDataEntity {
    val model = this
    return RecordDataEntity(
        this.id,
        AudioFilePathValueObject(this.audioFilePath),
        RecordDateValueObject(Date().apply { time = model.recordDate })
    )
}

internal fun List<RecordDataModel>.convertTo(): List<RecordDataEntity> {
    return this.map { it.convertTo() }
}