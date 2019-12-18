package com.prevent.data.recorddata.impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RecordDataModel::class), version = 1, exportSchema = true)
abstract class RecordDataDatabase : RoomDatabase() {

    abstract fun recordDataDao(): RecordDataDao

    companion object {
        @Volatile
        private var INSTANCE: RecordDataDatabase? = null

        fun getDatabase(context: Context): RecordDataDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecordDataDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
