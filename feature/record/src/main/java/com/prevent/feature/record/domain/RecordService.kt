package com.prevent.feature.record.domain

interface RecordService {
    val recordStatus: RecordStatus

    fun startRecord()
    fun stopRecord()
}