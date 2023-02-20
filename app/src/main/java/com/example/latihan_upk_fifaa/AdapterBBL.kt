package com.example.latihan_upk_fifaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterBBL (private val dataset: MutableList<DataBeratBadanIdeal>):
RecyclerView.Adapter<AdapterBBL.BBLHolder>(){
    class BBLHolder (view: View):RecyclerView.ViewHolder(view){
        val hasillist =view.findViewById<TextView>(R.id.hasilList)
        val btnHapus = view.findViewById<Button>(R.id.btnHapus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BBLHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_bbl,parent,false
        )
        return BBLHolder(view)
    }

    override fun onBindViewHolder(holder: BBLHolder, position: Int) {
        val data = dataset[position]
        holder.hasillist.text = dataset[position].hasillist
        holder.btnHapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position,dataset.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}