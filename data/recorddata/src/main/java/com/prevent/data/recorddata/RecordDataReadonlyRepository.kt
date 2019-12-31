package com.prevent.data.recorddata

import com.prevent.data.recorddata.model.collection.RecordDataCollection

interface RecordDataReadonlyRepository {
    suspend fun loadRecordData(): RecordDataCollection
}
