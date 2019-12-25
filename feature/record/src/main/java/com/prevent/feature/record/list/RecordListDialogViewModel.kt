package com.prevent.feature.record.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

internal class RecordListDialogViewModel(
    private val recordListLiveDataFactory: RecordListLiveDataFactory
) : ViewModel() {
    val recordListLiveData = recordListLiveDataFactory.create(viewModelScope)

    fun clearRecordData() {
        recordListLiveData.clear()
    }
}
