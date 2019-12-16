package com.prevent.feature.record.domain

import kotlinx.coroutines.flow.Flow

interface RecordService {
    val recordStatus: Flow<RecordStatus>

    fun startRecord()
    fun stopRecord()
}