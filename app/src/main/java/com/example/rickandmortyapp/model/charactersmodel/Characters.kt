package com.example.rickandmortyapp.model.charactersmodel


import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)