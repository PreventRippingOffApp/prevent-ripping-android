package com.prevent.data.recorddata

import com.prevent.data.recorddata.model.RecordDataEntity
import com.prevent.data.recorddata.model.collection.RecordDataCollection

interface RecordDataRepository {
    suspend fun updateRecordData(recordDataEntity: RecordDataEntity)

    suspend fun addRecordData(recordDataEntity: RecordDataEntity)

    suspend fun removeRecordData()
}