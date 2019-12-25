package com.prevent.data.recorddata.impl

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecordDataDao {
    @Query("SELECT * FROM RECORD_DATA")
    suspend fun getAll(): List<RecordDataModel>

    @Insert(entity = RecordDataModel::class)
    fun insertRecordData(data: RecordDataModel): Unit

    @Update(entity = RecordDataModel::class)
    fun updateRecordData(data: RecordDataModel): Unit

    @Query("DELETE FROM RECORD_DATA")
    fun removeAll(): Unit
}
