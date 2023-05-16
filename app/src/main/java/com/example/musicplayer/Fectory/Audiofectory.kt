package com.example.musicplayer.Fectory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicplayer.Repository.AudioRepository
import com.example.musicplayer.ViewModel.AudioViewModel

class Audiofectory(private val audioRepository: AudioRepository): ViewModelProvider.NewInstanceFactory()  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AudioViewModel(audioRepository) as T
    }

}