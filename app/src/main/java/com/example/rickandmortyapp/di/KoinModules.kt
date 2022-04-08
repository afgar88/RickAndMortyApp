package com.example.rickandmortyapp.di

import android.content.Context
import com.example.rickandmortyapp.network.RickAndMortyRepository
import com.example.rickandmortyapp.network.RickAndMortyRepositoryImp
import com.example.rickandmortyapp.network.RickAndMortyService
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

var TIME: Long = 30
val networkModule = module {
    fun providesLogginInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun providesOkHttpCLient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(TIME, TimeUnit.SECONDS)
            .readTimeout(TIME, TimeUnit.SECONDS)
            .writeTimeout(TIME, TimeUnit.SECONDS)
            .build()

    fun providesNetworkServices(okHttpClient: OkHttpClient): RickAndMortyService = Retrofit.Builder()
        .baseUrl(RickAndMortyService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(RickAndMortyService::class.java)

    fun provideRickAndMortyRepo(networkService: RickAndMortyService): RickAndMortyRepository =
        RickAndMortyRepositoryImp(networkService)


    single { providesLogginInterceptor() }
    single { providesOkHttpCLient(get()) }
    single { providesNetworkServices(get()) }
    single { provideRickAndMortyRepo(get()) }
}

val koinViewModelModule = module {
    viewModel {RickAndMortyViewModel(get(),get())}
}



