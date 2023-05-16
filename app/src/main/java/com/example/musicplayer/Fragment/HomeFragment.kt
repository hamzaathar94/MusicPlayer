package com.example.musicplayer.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.Adapter.MusicAdapter
import com.example.musicplayer.DB.Music
import com.example.musicplayer.Fectory.MediaFectory
import com.example.musicplayer.Interface.onAudioClick
import com.example.musicplayer.R
import com.example.musicplayer.Repository.FileRepository
import com.example.musicplayer.ViewModel.MusicViewModel
import com.example.musicplayer.databinding.FragmentHomeBinding

class HomeFragment : Fragment(),onAudioClick {
    private var binding:FragmentHomeBinding?=null
    private  var musicList: ArrayList<Music>?=null
    private  var recyclerView: RecyclerView?=null
    private  var musicAdapter: MusicAdapter?=null
    private var musicViewModel:MusicViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()),container,false)
        try {


            recyclerView = binding?.recyclerview
            val fileRepository = FileRepository(requireContext())
            musicViewModel = ViewModelProvider(
                this,
                MediaFectory(fileRepository)
            ).get(MusicViewModel::class.java)
            musicViewModel?.getAudio()
            recyclerView?.layoutManager = LinearLayoutManager(requireContext())
            musicViewModel?.getAudioLiveData()?.observe(requireActivity(), Observer {
                recyclerView?.adapter = MusicAdapter(requireContext(), it,this)
            })
        }catch (e:Exception){
            Toast.makeText(requireContext(), "Error !"+e.message, Toast.LENGTH_SHORT).show()
        }

        return binding?.root
    }


    override fun onAudioItemClick(music: Music) {
        try {
            val bundle=Bundle()
            bundle.putString("id",music.id.toString())
            bundle.putString("name",music.title)
            bundle.putString("album",music.album)
            bundle.putString("artist",music.artist)
            bundle.putString("path",music.path)
            bundle.putString("duration",music.duration.toString())
            findNavController().navigate(R.id.playerFragment,bundle)
        }catch (e:Exception){
            Toast.makeText(requireContext(), "Error !"+e.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAudioItemLongClick(music: Music) {
        Toast.makeText(requireContext(), "${music.title}", Toast.LENGTH_SHORT).show()
    }


}