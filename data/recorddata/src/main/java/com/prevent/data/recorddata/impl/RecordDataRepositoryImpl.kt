package com.prevent.data.recorddata.impl

import android.content.Context
import com.prevent.data.recorddata.RecordDataReadonlyRepository
import com.prevent.data.recorddata.RecordDataRepository
import com.prevent.data.recorddata.model.RecordDataEntity
import com.prevent.data.recorddata.model.collection.RecordDataCollection

internal class RecordDataRepositoryImpl(
    private val context: Context
) : RecordDataRepository,
    RecordDataReadonlyRepository {

    val recordDataDao: RecordDataDao = RecordDataDatabase.getDatabase(context).recordDataDao()

    override suspend fun updateRecordData(recordDataEntity: RecordDataEntity): Unit {
        recordDataDao.updateRecordData(recordDataEntity.convertTo())
    }

    override suspend fun addRecordData(recordDataEntity: RecordDataEntity): Unit {
        recordDataDao.insertRecordData(recordDataEntity.convertTo())
    }

    override suspend fun removeRecordData(): Unit {
        recordDataDao.removeAll()
    }

    override suspend fun loadRecordData(): RecordDataCollection {
        return RecordDataCollection(
            recordDataDao.getAll().convertTo()
        )
    }
}