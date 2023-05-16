package com.example.musicplayer.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.musicplayer.Adapter.FavouriteAdapter
import com.example.musicplayer.Adapter.MusicAdapter
import com.example.musicplayer.DB.AppDatabase
import com.example.musicplayer.Fectory.Audiofectory
import com.example.musicplayer.R
import com.example.musicplayer.Repository.AudioRepository
import com.example.musicplayer.ViewModel.AudioViewModel
import com.example.musicplayer.ViewModel.MusicViewModel
import com.example.musicplayer.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {
    private var binding:FragmentFavouriteBinding?=null
    private var recyclerView:RecyclerView?=null
    private var audioViewModel:AudioViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFavouriteBinding.inflate(LayoutInflater.from(requireContext()),
            container,false)
        recyclerView=binding?.recyclerview
        recyclerView?.layoutManager= StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        val db=AppDatabase.getDatabase(requireContext())
        val audioRepository=AudioRepository(db)
        audioViewModel=ViewModelProvider(this,Audiofectory(audioRepository)).get(AudioViewModel::class.java)
        audioViewModel?.music?.observe(viewLifecycleOwner, Observer {
            recyclerView?.adapter=FavouriteAdapter(requireContext(),it)
        })
        return binding?.root
    }


}