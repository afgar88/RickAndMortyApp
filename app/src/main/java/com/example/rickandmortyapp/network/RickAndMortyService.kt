package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.charactersmodel.Character
import com.example.rickandmortyapp.model.charactersmodel.Characters
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService {

    @GET(CHARACTERS_PATH)
    suspend fun getAllCharacters(): Response<Characters>


    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        private const val CHARACTERS_PATH = "character"
        private const val LOCATIONS_PATH = "location"
        private const val EPISODES_PATH = "episode"
    }

}