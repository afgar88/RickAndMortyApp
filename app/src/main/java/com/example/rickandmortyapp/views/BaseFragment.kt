package com.example.rickandmortyapp.views

import androidx.fragment.app.Fragment
import com.example.rickandmortyapp.adapter.CharacterAdapter
import com.example.rickandmortyapp.adapter.EpisodesAdapter
import com.example.rickandmortyapp.adapter.LocationAdapter
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseFragment : Fragment() {
    protected val rickAndMortyViewModel: RickAndMortyViewModel by sharedViewModel()

    protected val characterAdapter by lazy {
        CharacterAdapter()
    }
    protected val locationAdapter by lazy{
        LocationAdapter()
    }

    protected val episodeAdapter by lazy {
        EpisodesAdapter()
    }


}