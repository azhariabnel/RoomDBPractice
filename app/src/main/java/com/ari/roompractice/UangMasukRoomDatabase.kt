package com.ari.roompractice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UangMasuk::class], version = 1, exportSchema = false)
abstract class UangMasukRoomDatabase : RoomDatabase(){

    companion object {
        @Volatile
        private var INSTANCE: UangMasukRoomDatabase? = null

        fun getDatabase(context: Context): UangMasukRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, UangMasukRoomDatabase::class.java, "uangmasuk_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun getUangMasukDao() : UangMasukDao
}