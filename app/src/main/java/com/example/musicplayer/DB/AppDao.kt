package com.example.musicplayer.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Insert
    suspend fun  insertMusic(music: Music)


    @Query("SELECT * FROM music")
    fun getAllMusic() : LiveData<List<Music>>
}