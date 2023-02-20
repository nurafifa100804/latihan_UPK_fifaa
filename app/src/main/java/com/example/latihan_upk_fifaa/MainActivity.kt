package com.example.latihan_upk_fifaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var tb : Int = 0
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nama = findViewById<EditText>(R.id.txtnama)
        var tinggibadan = findViewById<EditText>(R.id.txttinggibadan)
        var jklaki_laki = findViewById<RadioButton>(R.id.rblaki_laki)
        var jkPerempuan = findViewById<RadioButton>(R.id.rbperempuan)
        var hitung = findViewById<Button>(R.id.btnhitung)
        var simpan = findViewById<TextView>(R.id.txtsimpan)
        var hasil = findViewById<TextView>(R.id.txthasil)
        recyclerView = findViewById(R.id.listdata)

        val data = mutableListOf<DataBeratBadanIdeal>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewAdapter = AdapterBBL(data)
        recyclerView.adapter=recyclerViewAdapter
        recyclerView.layoutManager = viewManager

        //Text Simpan
        simpan.setOnClickListener {
            val hasil = hasil.text.toString()

            val DataBBL = DataBeratBadanIdeal(hasil)
            data.add(DataBBL)
            recyclerViewAdapter.notifyDataSetChanged()
        }

        hitung.setOnClickListener {

            var tinggi = tinggibadan.text.toString().toInt()
            var nama = nama.text.toString()

            if (jklaki_laki.isChecked){
                tb = (tinggi - 100) - ((tinggi - 100) * 10 / 100)
                hasil.setText("Nama : $nama\nJenis Kelamin : Laki-Laki \nBerat Badan Idealmu : " + tb.toString() + "Kg")

            }else if (jkPerempuan.isChecked){
                tb = (tinggi - 100) - ((tinggi -100) * 15 /100)
                hasil.setText("Nama : $nama\nJenis Kelamin : Perempuan \nBerat Badan Idealmu : " + tb.toString() + "Kg")
            }
            else{
                hasil.setText("Pilih Jenis Kelamin Dulu")
            }
            }
        } }


