package com.example.musicplayer.DB

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.concurrent.TimeUnit
@Entity(tableName = "music")
data class Music(
    @PrimaryKey var id:Int,
    var title:String,
    var album:String,
    var artist:String,
    var duration: Long = 0,
    var path: String,
)

fun formatDuration(duration: Long):String{
    val minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.MILLISECONDS)
    val seconds = (TimeUnit.SECONDS.convert(duration, TimeUnit.MILLISECONDS) -
            minutes* TimeUnit.SECONDS.convert(1, TimeUnit.MINUTES))
    return String.format("%02d:%02d", minutes, seconds)
}
