package com.example.rickandmortyapp.views

import androidx.fragment.app.Fragment
import com.example.rickandmortyapp.viewmodel.RickAndMortyViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseFragment : Fragment() {
    protected val rickAndMortyViewModel: RickAndMortyViewModel by sharedViewModel()


}