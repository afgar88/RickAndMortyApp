package com.example.rickandmortyapp.model.episodesmodel


import com.google.gson.annotations.SerializedName

data class episodes(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val episodes: List<episode>
)