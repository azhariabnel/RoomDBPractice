package com.ari.roompractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var uangMasuk: UangMasuk
    private lateinit var databaseUangMasuk: UangMasukRoomDatabase
    private lateinit var dao: UangMasukDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseUangMasuk = UangMasukRoomDatabase.getDatabase(applicationContext)
        dao = databaseUangMasuk.getUangMasukDao()
        button.setOnClickListener {
            val id = etId.text.toString()
            val terima = etTerima.text.toString()
            val jumlah = etJumlah.text.toString()
            val keterangan = etKeterangan.text.toString()
            val tanggal = etTanggal.text.toString()
            val nomor = etNomor.text.toString()

            if (id.isEmpty() && terima.isEmpty()) {
                Toast.makeText(applicationContext, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            } else {
                saveUang(UangMasuk(id.toInt(),terima,keterangan,jumlah,tanggal,nomor))
            }
        }
        button2.setOnClickListener {
            getUangMasukData()
        }

    }

    private fun saveUang(uangMasuk: UangMasuk) {
        dao.insert(uangMasuk)
        dao.update(uangMasuk)
        Toast.makeText(applicationContext, "Data Berhasil Ditambah", Toast.LENGTH_SHORT).show()
    }

    private fun deleteUang(uangMasuk: UangMasuk){
        dao.delete(uangMasuk)
        Toast.makeText(applicationContext, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show()
    }

    private fun getUangMasukData() {
        val listItem = arrayListOf<UangMasuk>()
        listItem.addAll(dao.getAll())
        Toast.makeText(applicationContext, "Result$listItem", Toast.LENGTH_SHORT).show()
    }
}