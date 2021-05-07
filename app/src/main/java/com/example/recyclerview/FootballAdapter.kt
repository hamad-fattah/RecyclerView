package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FootballAdapter : RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {

    private var TName =  arrayOf("Barcelona","Real Madrid","Chelsea","Liverpool")
    private var TCName =  arrayOf("Spain","Spain","England","England")
    private var TLogo =  intArrayOf(R.drawable.barcelona_logo,R.drawable.real_madrid_logo,R.drawable.chelsea_logo,R.drawable.liverpool_logo)

    inner class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var teamLogo : ImageView = itemView.findViewById(R.id.team_logo)
        var teamName : TextView = itemView.findViewById(R.id.team_name)
        var teamCapitalName : TextView = itemView.findViewById(R.id.team_country_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballAdapter.FootballViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.football_team_card,parent,false)
        return FootballViewHolder(v)
    }

    override fun onBindViewHolder(holder: FootballAdapter.FootballViewHolder, position: Int) {
        holder.teamName.text = TName[position]
        holder.teamCapitalName.text = TCName[position]
        holder.teamLogo.setImageResource(TLogo[position])
    }

    override fun getItemCount(): Int {
        return TName.size
    }


}