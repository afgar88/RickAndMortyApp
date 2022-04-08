package com.example.rickandmortyapp

import android.app.Application
import com.example.rickandmortyapp.di.koinViewModelModule
import com.example.rickandmortyapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@RickAndMortyApp)
            modules(listOf(networkModule, koinViewModelModule))
        }
    }
}