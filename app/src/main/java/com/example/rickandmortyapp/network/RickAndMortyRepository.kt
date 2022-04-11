package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.charactersmodel.Character
import com.example.rickandmortyapp.model.charactersmodel.Characters
import com.example.rickandmortyapp.model.episodesmodel.episodes
import com.example.rickandmortyapp.model.locationmodel.Locations
import retrofit2.Response

interface RickAndMortyRepository {
    suspend fun getAllCharacters(): Response<Characters>
    suspend fun getAllLocations(): Response<Locations>
    suspend fun getAllEpisodes(): Response<episodes>
}

class RickAndMortyRepositoryImp(
    private val rickAndMortyService: RickAndMortyService
) : RickAndMortyRepository {
    override suspend fun getAllCharacters(): Response<Characters> =
        rickAndMortyService.getAllCharacters()

    override suspend fun getAllLocations(): Response<Locations> =
        rickAndMortyService.getAllLocations()


    override suspend fun getAllEpisodes(): Response<episodes> =
        rickAndMortyService.getAllEpisodes()


}