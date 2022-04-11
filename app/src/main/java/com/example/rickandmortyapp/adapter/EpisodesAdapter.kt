package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.episodesmodel.episode

class EpisodesAdapter(
    private var episodesList: MutableList<episode> = mutableListOf()

) : RecyclerView.Adapter<EpisodesViewAdapter>() {

    fun update(episodeL: List<episode>) {
        episodesList.clear()
        episodesList.addAll(episodeL)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewAdapter {
        val episodesItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_episode, parent, false)
        return EpisodesViewAdapter(episodesItem)
    }

    override fun onBindViewHolder(holder: EpisodesViewAdapter, position: Int) {
        val my_episode = episodesList[position]
        holder.bind(my_episode)
    }

    override fun getItemCount(): Int = episodesList.size


}


class EpisodesViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.episode_name_id)
    private val airDate: TextView = itemView.findViewById(R.id.episode_air_date_id)
    private val episode: TextView = itemView.findViewById(R.id.episode_episode_id)

    fun bind(episodeInfo: episode) {
        name.text = episodeInfo.name
        airDate.text = episodeInfo.airDate
        episode.text = episodeInfo.episode
    }

}