package com.ari.roompractice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Rekening::class], version = 1, exportSchema = false)
abstract class RekeningRoomDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: RekeningRoomDatabase? = null

        fun getDatabase(context: Context): RekeningRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, RekeningRoomDatabase::class.java, "rekening_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getRekeningDao() : RekeningDao
}