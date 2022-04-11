package com.example.rickandmortyapp.model.locationmodel


import com.google.gson.annotations.SerializedName

data class Locations(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val location: List<Location>
)