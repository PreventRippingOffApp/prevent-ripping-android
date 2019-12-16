package com.prevent.feature.record.domain

sealed class RecordStatus() {
    class notRecording() : RecordStatus()
    class recording() : RecordStatus()

}