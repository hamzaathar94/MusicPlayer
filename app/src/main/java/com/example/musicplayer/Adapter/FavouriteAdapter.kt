package com.example.musicplayer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.DB.Music
import com.example.musicplayer.databinding.MusicItemBinding

class FavouriteAdapter(private var context: Context,val data:List<Music>):
    RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.MyViewHolder {

        val binding=MusicItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.MyViewHolder, position: Int) {
        val musicList=data[position]
        holder.binding.txtsongname.text=musicList.title
        holder.binding.txtalbum.text=musicList.album
        holder.binding.txtduration.text=musicList.duration.toString()

//        holder.itemView.setOnClickListener {
//            onItemClick.onShortClick(position, product)
//        }
//
//        holder.itemView.setOnLongClickListener {
//            onItemClick.onLongClick(position, product)
//
//            true
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(var binding: MusicItemBinding): RecyclerView.ViewHolder(binding.root) {

    }
}