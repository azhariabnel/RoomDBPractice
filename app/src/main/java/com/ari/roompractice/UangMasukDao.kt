package com.ari.roompractice

import androidx.room.*

@Dao
interface UangMasukDao {

    @Insert
    fun insert (uangMasuk: UangMasuk)

    @Update
    fun update (uangMasuk: UangMasuk)

    @Delete
    fun delete (uangMasuk: UangMasuk)

    @Query("SELECT * FROM uangmasuk")
    fun getAll() : List<UangMasuk>

    @Query("SELECT * FROM uangmasuk WHERE UangMasukID = :id")
    fun getById(id : Int) : List<UangMasuk>

}