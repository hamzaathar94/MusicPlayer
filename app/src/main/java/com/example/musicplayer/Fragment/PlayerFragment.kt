package com.example.musicplayer.Fragment

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.musicplayer.DB.Music
import com.example.musicplayer.R
import com.example.musicplayer.ViewModel.AudioViewModel
import com.example.musicplayer.databinding.FragmentPlayerBinding
import java.io.IOException

class PlayerFragment : Fragment() {
    private var binding:FragmentPlayerBinding?=null
    private var music:Music?=null
    private  var mediaPlayer: MediaPlayer?=null
    private var isPlaying: Boolean=false
    private var audioViewModel:AudioViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPlayerBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        mediaPlayer = MediaPlayer()
        try {
            binding?.imgbtnfav?.setOnClickListener {
               // var id=arguments?.getString("id")
                //Toast.makeText(requireContext(), "${id.toString()}", Toast.LENGTH_SHORT).show()
                addMusic()
            }

            binding?.btnplay?.setOnClickListener{
             createPlayer()
            }
            binding?.btnpause?.setOnClickListener {
                mediaPlayer?.pause()
            }
            binding?.btnnext?.setOnClickListener {
               // Toast.makeText(requireContext(), "Im click", Toast.LENGTH_SHORT).show()

            }

            binding?.btnpre?.setOnClickListener {
                Toast.makeText(requireContext(), "Im click", Toast.LENGTH_SHORT).show()
            }

        }catch (e:Exception){
            Toast.makeText(requireContext(), "Error !"+e.message, Toast.LENGTH_SHORT).show()
        }

        return binding?.root
    }

    fun addMusic(){
        try {
            val id=arguments?.getString("id")
            val title=arguments?.getString("title")
            val album=arguments?.getString("album")
            val artist=arguments?.getString("artist")
            val duration=arguments?.getString("duration")
            val path=arguments?.getString("path")
            //audioViewModel?.insertMusic(id!!.toInt(),title.toString(),album.toString(),artist.toString(),
            // duration!!.toLong(),path.toString())
            audioViewModel?.insertMusic(1,"a","b","c",1200,"f")
            Toast.makeText(requireContext(), "${audioViewModel}", Toast.LENGTH_SHORT).show()
//            Log.d("000","id:"+id.toString())
//            Log.d("000","title:"+title.toString())
//            Log.d("000","album:"+album.toString())
//            Log.d("000","artist:"+artist.toString())
//            Log.d("000","duration:"+duration.toString())
//            Log.d("000","path"+path.toString())
           // Toast.makeText(requireContext(), "successful", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.favouriteFragment)
        }catch (e:Exception){
            Toast.makeText(requireContext(), "Error !"+e.message, Toast.LENGTH_SHORT).show()
        }

    }
    fun createPlayer(){
        //Toast.makeText(requireContext(), "Im click", Toast.LENGTH_SHORT).show()
        try {
            val path=arguments?.getString("path")
            mediaPlayer?.reset()
            mediaPlayer?.setDataSource(path)
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        }catch (e:Exception){
            Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
        }
    }



}