package com.prevent.data.recorddata.model

import com.prevent.data.recorddata.model.valueobject.AudioFilePathValueObject
import com.prevent.data.recorddata.model.valueobject.RecordDateValueObject

data class RecordDataEntity(
    val id: Int,
    val audioFilePath: AudioFilePathValueObject,
    val recordDate: RecordDateValueObject = RecordDateValueObject.now()
)