package com.example.rickandmortyapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentLocationsBinding
import com.example.rickandmortyapp.model.locationmodel.Locations
import com.example.rickandmortyapp.utils.RickAndMortyState


class LocationsFragment : BaseFragment() {

    val binding by lazy {
        FragmentLocationsBinding.inflate(layoutInflater)
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
        binding.recyclerLocation.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = locationAdapter
        }
        rickAndMortyViewModel.getAllLocations()
        Log.d("Location", rickAndMortyViewModel.getAllLocations().toString())
        rickAndMortyViewModel.allLocations.observe(viewLifecycleOwner) { state ->
            when (state) {
                is RickAndMortyState.LOADING -> {
                    Toast.makeText(requireContext(), "loading...", Toast.LENGTH_LONG).show()
                }
                is RickAndMortyState.SUCCESS<*> -> {

                    var locations: Locations = state.data as Locations
                    locationAdapter.update(locations.location)
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
         * @return A new instance of fragment LocationsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocationsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}