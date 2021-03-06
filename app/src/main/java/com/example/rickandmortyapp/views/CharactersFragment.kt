package com.example.rickandmortyapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentCharactersBinding
import com.example.rickandmortyapp.model.charactersmodel.Characters
import com.example.rickandmortyapp.utils.RickAndMortyState


class CharactersFragment : BaseFragment() {

    val binding by lazy {
        FragmentCharactersBinding.inflate(layoutInflater)
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

        binding.recyclerCharacter.apply {
            layoutManager =

                    GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
                    //LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = characterAdapter
        }

        rickAndMortyViewModel.getAllCharacters()
        Log.d("Characters", rickAndMortyViewModel.getAllCharacters().toString())

        rickAndMortyViewModel.allCharacters.observe(viewLifecycleOwner) { state ->
            when (state) {
                is RickAndMortyState.LOADING -> {
                    Toast.makeText(requireContext(), "loading...", Toast.LENGTH_LONG).show()
                }
                is RickAndMortyState.SUCCESS<*> -> {




                    var characters:Characters = state.data as Characters


                   characterAdapter.updateData(characters.characters)

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


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CharactersFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CharactersFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}