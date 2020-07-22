package com.example.androidkotlinquizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_game.view.*

class GameAdapter(var game:List<GameData>):RecyclerView.Adapter<GameAdapter.GameViewHolder>(){

    inner class GameViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflatedView=LayoutInflater.from(parent.context).inflate(R.layout.activity_game,parent,false)
        return GameViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return game.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.itemView.apply {
            btnAlpha.text=game[position].buttonLabel
        }
    }



}