package com.example.musicplayer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.DB.Music
import com.example.musicplayer.DB.formatDuration
import com.example.musicplayer.Interface.onAudioClick
import com.example.musicplayer.databinding.MusicItemBinding

class MusicAdapter(var context: Context, val data: List<Music>,private var onAudioClick: onAudioClick) :
    RecyclerView.Adapter<MusicAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicAdapter.
    MyViewHolder {
        val binding=MusicItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicAdapter.MyViewHolder, position: Int) {
        val musiclist=data[position]
        holder.binding.txtsongname.text=musiclist.title
        holder.binding.txtalbum.text=musiclist.album
        holder.binding.txtduration.text= formatDuration(musiclist.duration)

        holder.itemView.setOnClickListener {
            onAudioClick.onAudioItemClick(musiclist)
        }

        holder.itemView.setOnLongClickListener {
            onAudioClick.onAudioItemLongClick(musiclist)
            true
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(var binding: MusicItemBinding):RecyclerView.ViewHolder(binding.root){

    }
}