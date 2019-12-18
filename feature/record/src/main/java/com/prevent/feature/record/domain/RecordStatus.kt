package com.prevent.feature.record.domain

sealed class RecordStatus {
    class NotRecording : RecordStatus()
    class R ecording : RecordStatus()

}