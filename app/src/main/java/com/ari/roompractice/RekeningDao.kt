package com.ari.roompractice

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface RekeningDao {

    @Insert
    fun insert (rekening: Rekening)

    @Update
    fun update (rekening: Rekening)

    @Delete
    fun delete (rekening: Rekening)

    @Query("SELECT * FROM rekening")
    fun getAll() : List<Rekening>

    @Query("SELECT * FROM rekening WHERE RekeningID = :id")
    fun getById(id : Int) : List<Rekening>
}