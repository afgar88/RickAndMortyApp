package com.example.rickandmortyapp.utils

sealed class RickAndMortyState {
    object LOADING:RickAndMortyState()
    class SUCCESS<T>(val data:T):RickAndMortyState()
    class ERROR(val error:Throwable):RickAndMortyState()

}