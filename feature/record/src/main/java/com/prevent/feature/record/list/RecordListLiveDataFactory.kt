package com.prevent.feature.record.list

import com.prevent.data.recorddata.RecordDataReadonlyRepository
import com.prevent.data.recorddata.RecordDataRepository
import kotlinx.coroutines.CoroutineScope

internal class RecordListLiveDataFactory(
    private val recordDataReadonlyRepository: RecordDataReadonlyRepository,
    private val recordDataRepository: RecordDataRepository
) {
    fun create(
        coroutineScope: CoroutineScope
    ): RecordListLiveData {
        return RecordListLiveData(
            coroutineScope,
            recordDataReadonlyRepository,
            recordDataRepository
        )
    }
}