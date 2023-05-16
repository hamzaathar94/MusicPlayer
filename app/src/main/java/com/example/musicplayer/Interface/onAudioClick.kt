package com.example.musicplayer.Interface

import com.example.musicplayer.DB.Music

interface onAudioClick {
    fun onAudioItemClick(music: Music)
    fun onAudioItemLongClick(music: Music)
}