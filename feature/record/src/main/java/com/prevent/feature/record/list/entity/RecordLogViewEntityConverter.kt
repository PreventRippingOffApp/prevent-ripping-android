package com.prevent.feature.record.list.entity

import com.prevent.data.recorddata.model.RecordDataEntity
import java.text.SimpleDateFormat
import java.util.Date

private fun Date.format(format: String): String {
    return SimpleDateFormat(format).format(this)
}

internal fun RecordDataEntity.convertTo(): RecordLogViewEntity {
    return RecordLogViewEntity(
        this.id,
        this.recordDate.date.format("yyyy/MM/dd HH:mm")
    )
}

internal fun List<RecordDataEntity>.converTo(): List<RecordLogViewEntity> = this.map {
    it.convertTo()
}
