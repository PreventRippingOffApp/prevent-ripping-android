package com.prevent.data.recorddata.model.valueobject

import java.util.Date

data class RecordDateValueObject(val date: Date) {
    companion object {
        fun now(): RecordDateValueObject {
            return RecordDateValueObject(
                Date()
            )
        }
    }
}
