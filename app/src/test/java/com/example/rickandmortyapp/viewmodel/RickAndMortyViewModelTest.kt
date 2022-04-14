package com.example.rickandmortyapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmortyapp.model.charactersmodel.Characters
import com.example.rickandmortyapp.network.RickAndMortyRepository
import com.example.rickandmortyapp.utils.RickAndMortyState
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RickAndMortyViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private val testDispatcher = UnconfinedTestDispatcher()

    private val mockRepository = mockk<RickAndMortyRepository>(relaxed = true)

    lateinit var target: RickAndMortyViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        target = RickAndMortyViewModel(mockRepository, testDispatcher)
    }

    @After
    fun shutdown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `get all characters when trying to load from server returns loading state`() {

        val stateList = mutableListOf<RickAndMortyState>()
        target.allCharacters.observeForever {
            stateList.add(it)
        }

        target.getAllCharacters()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)


    }

    @Test
    fun `get all characters when trying to load from server returns success state`() = runTest {

        coEvery { mockRepository.getAllCharacters() } returns mockk {
            every { isSuccessful } returns true
            every { body() } returns mockk { mockk<Characters>() }
        }

        val stateList = mutableListOf<RickAndMortyState>()
        target.allCharacters.observeForever {
            stateList.add(it)
        }

        target.getAllCharacters()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList).hasSize(3)
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[2]).isInstanceOf(RickAndMortyState.SUCCESS::class.java)


    }


    @Test
    fun `get all locations when trying to load from server returns loading state`() {

        val stateList = mutableListOf<RickAndMortyState>()
        target.allLocations.observeForever {
            stateList.add(it)
        }

        target.getAllLocations()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)


    }

    @Test
    fun `get all locations when trying to load from server returns success state`() = runTest {

        coEvery { mockRepository.getAllLocations() } returns mockk {
            every { isSuccessful } returns true
            every { body() } returns mockk { mockk<Characters>() }
        }

        val stateList = mutableListOf<RickAndMortyState>()
        target.allLocations.observeForever {
            stateList.add(it)
        }

        target.getAllLocations()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList).hasSize(3)
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[2]).isInstanceOf(RickAndMortyState.SUCCESS::class.java)


    }

    @Test
    fun `get all episodes when trying to load from server returns loading state`() {


        val stateList = mutableListOf<RickAndMortyState>()
        target.allepisodes.observeForever {
            stateList.add(it)
        }

        target.getAllEpisodes()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)


    }

    @Test
    fun `get all episodes when trying to load from server returns success state`() = runTest {

        coEvery { mockRepository.getAllEpisodes() } returns mockk {
            every { isSuccessful } returns true
            every { body() } returns mockk { mockk<Characters>() }
        }

        val stateList = mutableListOf<RickAndMortyState>()
        target.allepisodes.observeForever {
            stateList.add(it)
        }

        target.getAllEpisodes()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList).hasSize(3)
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[2]).isInstanceOf(RickAndMortyState.SUCCESS::class.java)


    }


}