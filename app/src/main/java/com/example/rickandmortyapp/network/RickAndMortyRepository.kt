package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.charactersmodel.Character
import com.example.rickandmortyapp.model.charactersmodel.Characters
import retrofit2.Response

interface RickAndMortyRepository {
    suspend fun getAllCharacters(): Response<Characters>
}

class RickAndMortyRepositoryImp(
    private val rickAndMortyService: RickAndMortyService
) : RickAndMortyRepository {
    override suspend fun getAllCharacters(): Response<Characters> =
        rickAndMortyService.getAllCharacters()


}