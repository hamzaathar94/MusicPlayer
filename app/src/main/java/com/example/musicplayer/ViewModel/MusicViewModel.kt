package com.example.musicplayer.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer.DB.Music
import com.example.musicplayer.Repository.FileRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MusicViewModel(private val fileRepository: FileRepository): ViewModel() {
    //******* Audio**************
    val audio: MutableLiveData<List<Music>> = fileRepository.audioLiveData

    fun getAudio() {
        fileRepository.getAudio()
    }

    fun getAudioLiveData(): LiveData<List<Music>> {
        fileRepository.getAudioLiveData()
        return audio
    }


}