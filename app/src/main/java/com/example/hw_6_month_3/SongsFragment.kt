package com.example.hw_6_month_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import com.example.hw_6_month_3.databinding.FragmentSongsBinding

class SongsFragment : Fragment() {

    private lateinit var binding: FragmentSongsBinding
    private lateinit var adapter: SongAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       var list = ArrayList<Song>()
        list.add(Song("1","Самурай","Miyagi","2:44"))
        list.add(Song("2","Mox","Oxxxymiron","2:06"))
        list.add(Song("3","Полигон","Oxxxymiron","3:40"))
        list.add(Song("4","Переплетено","Oxxxymiron","4:51"))
        list.add(Song("5","A Place for My Head","Linkin Park","3:04"))
        list.add(Song("6","Don`t Stay","Linkin Park","3:08"))
        list.add(Song("7","Papercut","Linkin Park","3:04"))
        list.add(Song("8","Minor","Miyagi & Andy Panda","2:55"))
        list.add(Song("9","Yamakasi","Miyagi & Andy Panda","4:24"))
        list.add(Song("10","Superman","Eminem feat Dina Rae","5:50"))
        list.add(Song("11","Without Me","Eminem","4:52"))
        list.add(Song("12","Mockingbird","Eminem","4:12"))

        adapter = SongAdapter(list,this::onItemClick)
        binding.recyclerView.adapter = adapter

    }
    private fun onItemClick(title:String){
        requireActivity().supportFragmentManager.findFragmentById(R.id.image_layout)?.view?.isGone=true
        val bundle = Bundle()
        bundle.putString("Name",title)
        val infoSongFragment = InfoSongFragment()
        infoSongFragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.songs_layout,infoSongFragment).commit()
    }
}