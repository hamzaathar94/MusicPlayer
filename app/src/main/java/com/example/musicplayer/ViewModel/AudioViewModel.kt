package com.example.musicplayer.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer.DB.Music
import com.example.musicplayer.Repository.AudioRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AudioViewModel(private val audioRepository: AudioRepository):ViewModel() {

    val music: LiveData<List<Music>> = audioRepository.getAllData()

    fun insertMusic(id:Int,title:String,album:String,artist:String,duration:Long,path:String){
        GlobalScope.launch {
            val music=Music(id,title,album,artist,duration.toLong(),path)
            audioRepository.insertMusic(music)
        }
    }
}