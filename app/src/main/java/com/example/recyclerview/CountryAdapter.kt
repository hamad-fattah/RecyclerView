package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var CName =  arrayOf("Lebanon","France","USA","China")
    private var CCName =  arrayOf("Beirut","Paris","Washington","Beijing")
    private var CFlag =  intArrayOf(R.drawable.lebanon_flag,R.drawable.france_flag,R.drawable.usa_flag,R.drawable.china_flag)

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var countryFlag : ImageView = itemView.findViewById(R.id.country_flag)
        var countryName : TextView = itemView.findViewById(R.id.country_name)
        var countryCapitalName : TextView = itemView.findViewById(R.id.country_capital_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.CountryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.countries_card,parent,false)
        return CountryViewHolder(v)
    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {
        holder.countryName.text = CName[position]
        holder.countryCapitalName.text = CCName[position]
        holder.countryFlag.setImageResource(CFlag[position])
    }

    override fun getItemCount(): Int {
        return CName.size
    }


}