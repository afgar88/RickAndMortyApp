package com.example.rickandmortyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.network.RickAndMortyRepository
import com.example.rickandmortyapp.utils.RickAndMortyState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.lang.Exception

class RickAndMortyViewModel(
    private val networkRepo: RickAndMortyRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

) : ViewModel() {

    val _characters: MutableLiveData<RickAndMortyState> = MutableLiveData(RickAndMortyState.LOADING)
    val allCharacters: LiveData<RickAndMortyState> get() = _characters

    val _locations: MutableLiveData<RickAndMortyState> = MutableLiveData(RickAndMortyState.LOADING)
    val allLocations: LiveData<RickAndMortyState> get() = _locations

    val _episodes: MutableLiveData<RickAndMortyState> = MutableLiveData(RickAndMortyState.LOADING)
    val allepisodes: LiveData<RickAndMortyState> get() = _episodes

    fun getAllCharacters() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = networkRepo.getAllCharacters()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _characters.postValue(RickAndMortyState.SUCCESS(it))

                    } ?: throw Exception("Response is null")
                } else {
                    throw Exception("No successful response")
                }
            } catch (e: Exception) {
                _characters.postValue(RickAndMortyState.ERROR(e))
            }

        }
    }

    fun getAllLocations() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = networkRepo.getAllLocations()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _locations.postValue(RickAndMortyState.SUCCESS(it))

                    } ?: throw Exception("Response is null")
                } else {
                    throw Exception("No successful response")
                }
            } catch (e: Exception) {
                _locations.postValue(RickAndMortyState.ERROR(e))
            }

        }
    }

    fun getAllEpisodes() {
        viewModelScope.launch(ioDispatcher) {
            try {
                val response = networkRepo.getAllEpisodes()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _episodes.postValue(RickAndMortyState.SUCCESS(it))

                    } ?: throw Exception("Response is null")
                } else {
                    throw Exception("No successful response")
                }
            } catch (e: Exception) {
                _episodes.postValue(RickAndMortyState.ERROR(e))
            }

        }
    }

}