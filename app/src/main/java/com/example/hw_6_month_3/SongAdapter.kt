package com.example.hw_6_month_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hw_6_month_3.databinding.ItemSongBinding

class SongAdapter(private val list: ArrayList<Song>, private val onItemClick:(tvName:String)->Unit) : Adapter<SongAdapter.SongViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            ItemSongBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class SongViewHolder(private val binding: ItemSongBinding) : ViewHolder(binding.root) {
        fun bind(song: Song) {
            binding.apply {
                tvNumber.text = song.number
                tvName.text = song.title
                tvAuthor.text = song.author
                tvDuration.text = song.time
                root.setOnClickListener {
                    onItemClick(list[adapterPosition].title)
                }
            }

        }

    }
}