package com.prevent.feature.record.list

import androidx.lifecycle.LiveData
import com.prevent.data.recorddata.RecordDataReadonlyRepository
import com.prevent.data.recorddata.RecordDataRepository
import com.prevent.feature.record.list.entity.RecordLogViewEntity
import com.prevent.feature.record.list.entity.converTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class RecordListLiveData(
    private val coroutineScope: CoroutineScope,
    private val recordDataReadonlyRepository: RecordDataReadonlyRepository,
    private val recordDataRepository: RecordDataRepository
) : LiveData<List<RecordLogViewEntity>>() {
    init {
        refreshRecordData()
    }

    private fun refreshRecordData() {
        coroutineScope.launch(Dispatchers.IO) {
            val recordData = recordDataReadonlyRepository.loadRecordData()
            postValue(recordData.collection.converTo())
        }
    }

    fun clear() {
        coroutineScope.launch(Dispatchers.IO) {
            recordDataRepository.removeRecordData()
        }
        refreshRecordData()
    }
}
