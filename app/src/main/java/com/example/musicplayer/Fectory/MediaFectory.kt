package com.example.musicplayer.Fectory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicplayer.Repository.FileRepository
import com.example.musicplayer.ViewModel.MusicViewModel

class MediaFectory(val fileRepository: FileRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MusicViewModel(fileRepository) as T
    }


}