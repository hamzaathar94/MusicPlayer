package com.example.musicplayer.Repository

import androidx.lifecycle.LiveData
import com.example.musicplayer.DB.AppDatabase
import com.example.musicplayer.DB.Music

class AudioRepository(private val appDatabase: AppDatabase) {

    fun getAllData(): LiveData<List<Music>> {
        return appDatabase.appDao().getAllMusic()
    }

    suspend fun insertMusic(music: Music){
        appDatabase.appDao().insertMusic(music)
    }
}