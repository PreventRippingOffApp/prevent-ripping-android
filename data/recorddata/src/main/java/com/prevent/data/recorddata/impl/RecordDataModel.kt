package com.prevent.data.recorddata.impl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// data class RecordDataEntity(
//    val id: Int,
//    val audioFilePath: AudioFilePathValueObject,
//    val recordDate: RecordDateValueObject = RecordDateValueObject.now()
// )

@Entity(tableName = "record_data")
data class RecordDataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "audio_file_path")
    val audioFilePath: String,
    @ColumnInfo(name = "record_date")
    val recordDate: Long
)
