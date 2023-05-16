package com.example.musicplayer.Repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musicplayer.DB.AppDatabase
import com.example.musicplayer.DB.Music

class FileRepository(val context: Context) {
    // audio

    val audioLiveData = MutableLiveData<List<Music>>()

    @SuppressLint("Range")
    fun getAudio() {
        val audio = mutableListOf<Music>()
// Use content resolver to query for music files on device
        val musicCurser = context.contentResolver?.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            null,
            null,
            null,
            null
        )
        // Iterate through cursor to get music file information
        if (musicCurser != null && musicCurser.moveToFirst()) {
            do {
                val title =
                    musicCurser.getString(musicCurser.getColumnIndex(MediaStore.Audio.Media.TITLE))
                val path =
                    musicCurser.getString(musicCurser.getColumnIndex(MediaStore.Audio.Media.DATA))
                val duration=
                    musicCurser.getString(musicCurser.getColumnIndex(MediaStore.Audio.Media.DURATION))
                val album=
                    musicCurser.getString(musicCurser.getColumnIndex(MediaStore.Audio.Media.ALBUM))
                val artist=
                    musicCurser.getString(musicCurser.getColumnIndex(MediaStore.Audio.Media.ARTIST))
                val id=
                    musicCurser.getString(musicCurser.getColumnIndex(MediaStore.Audio.Media._ID))
                audio.add(Music(id.toInt(),title, album,artist,duration.toLong(),path))
            } while (musicCurser.moveToNext())
            musicCurser.close()
            audioLiveData.postValue(audio)
        }
    }

    fun getAudioLiveData(): LiveData<List<Music>> {
        return audioLiveData
    }


}