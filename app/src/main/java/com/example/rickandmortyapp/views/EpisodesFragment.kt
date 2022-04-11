package com.example.rickandmortyapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.example.rickandmortyapp.databinding.FragmentLocationsBinding
import com.example.rickandmortyapp.model.episodesmodel.episode
import com.example.rickandmortyapp.model.episodesmodel.episodes
import com.example.rickandmortyapp.utils.RickAndMortyState


class EpisodesFragment : BaseFragment() {

    val binding by lazy {
        FragmentEpisodesBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerEpisodes.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = episodeAdapter
        }

        rickAndMortyViewModel.getAllEpisodes()
        Log.d("Episodes", rickAndMortyViewModel.getAllEpisodes().toString())

        rickAndMortyViewModel.allepisodes.observe(viewLifecycleOwner) { state ->
            when (state) {
                is RickAndMortyState.LOADING -> {
                    Toast.makeText(requireContext(), "Loading...", Toast.LENGTH_LONG).show()
                }
                is RickAndMortyState.SUCCESS<*> -> {
                    var episodes: episodes = state.data as episodes
                    episodeAdapter.update(episodes.episodes)
                }
                is RickAndMortyState.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        state.error.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }

        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EpisodesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EpisodesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}