package com.ari.roompractice

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "uangmasuk")

@Parcelize
data class UangMasuk(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "UangMasukID") var id: Int = 0,
    @ColumnInfo(name = "TerimaDari") var terimaDari: String = "",
    @ColumnInfo(name = "Keterangan") var keterangan: String = "",
    @ColumnInfo(name = "Jumlah") var jumlah: String = "",
    @ColumnInfo(name = "Tanggal") var tanggal: String = "",
    @ColumnInfo(name = "Nomor") var nomor: String = ""
) : Parcelable

@Entity(foreignKeys = arrayOf(ForeignKey(entity = UangMasuk::class,parentColumns = arrayOf("UangMasukID"),childColumns = arrayOf("RekeningID"))))

@Parcelize
data class Rekening(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "RekeningID") var id: Int = 0,
    @ColumnInfo(name = "NamaBank") var namaBank: String = "",
    @ColumnInfo(name = "NomorRekening") var noRekening: String = "",
    @ColumnInfo(name = "AtasNama") var atasNama: String = "",
): Parcelable
