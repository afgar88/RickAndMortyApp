package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.model.charactersmodel.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(
    private var characterList: List<Character> = listOf()
) : RecyclerView.Adapter<CharacterViewAdapter>() {

    fun updateData(characterL: List<Character>) {
        characterList = characterL
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewAdapter {
        val characterItem =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewAdapter(characterItem)
    }

    override fun onBindViewHolder(holder: CharacterViewAdapter, position: Int) {
        val my_character = characterList[position]
        holder.bind(my_character)

    }

    override fun getItemCount(): Int = characterList.size
}


class CharacterViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.txtName)
    private val specie: TextView = itemView.findViewById(R.id.txtSpecie)
    private val status: TextView = itemView.findViewById(R.id.txtStatus)
    private val image: ImageView = itemView.findViewById(R.id.character_picture)

    fun bind(characterInfo: Character) {
        name.text = characterInfo.name
        specie.text = characterInfo.species
        status.text = characterInfo.status

        Picasso.get().load(characterInfo.image)
            .into(image)
    }
}