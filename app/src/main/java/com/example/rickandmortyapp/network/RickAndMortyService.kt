package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.charactersmodel.Character
import com.example.rickandmortyapp.model.charactersmodel.Characters
import com.example.rickandmortyapp.model.episodesmodel.episodes
import com.example.rickandmortyapp.model.locationmodel.Locations
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService {

    @GET(CHARACTERS_PATH)
    suspend fun getAllCharacters(): Response<Characters>
    @GET(LOCATIONS_PATH)
    suspend fun getAllLocations():Response<Locations>
    @GET(EPISODES_PATH)
    suspend fun getAllEpisodes():Response<episodes>


    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        private const val CHARACTERS_PATH = "character"
        private const val LOCATIONS_PATH = "location"
        private const val EPISODES_PATH = "episode"
    }

}