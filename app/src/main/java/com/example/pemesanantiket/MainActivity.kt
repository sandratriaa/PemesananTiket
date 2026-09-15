package com.example.pemesanantiket

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    // Data tiket
    private val hargaTiket = 25000
    private var jumlahTiket = 1
    private val minimalTiket = 1

    // View
    private lateinit var tvJumlah: TextView
    private lateinit var tvTotal: TextView
    private lateinit var btnMinus: ImageButton
    private lateinit var btnPlus: ImageButton
    private lateinit var btnReset: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hubungkan variabel dengan komponen di layout
        tvJumlah = findViewById(R.id.tvJumlah)
        tvTotal = findViewById(R.id.tvTotal)
        btnMinus = findViewById(R.id.btnMinus)
        btnPlus = findViewById(R.id.btnPlus)
        btnReset = findViewById(R.id.btnReset)

        updateTampilan()

        // Tombol kurang (-)
        btnMinus.setOnClickListener {
            if (jumlahTiket > minimalTiket) {
                jumlahTiket--
                updateTampilan()
            }
        }

        // Tombol tambah (+)
        btnPlus.setOnClickListener {
            jumlahTiket++
            updateTampilan()
        }

        // Tombol reset
        btnReset.setOnClickListener {
            jumlahTiket = minimalTiket
            updateTampilan()
        }
    }

    // Memperbarui angka jumlah tiket dan total bayar
    private fun updateTampilan() {
        tvJumlah.text = jumlahTiket.toString()
        val total = hargaTiket * jumlahTiket
        tvTotal.text = formatRupiah(total)
    }

    // Format angka menjadi Rp25.000
    private fun formatRupiah(nominal: Int): String {
        val format = NumberFormat.getNumberInstance(Locale("in", "ID"))
        return "Rp" + format.format(nominal)
    }
}