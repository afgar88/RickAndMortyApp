package com.example.rickandmortyapp.viewmodel

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmortyapp.network.RickAndMortyRepository
import com.example.rickandmortyapp.utils.RickAndMortyState
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class RickAndMortyViewModelTest {

    @get:Rule var rule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private val testCoroutinesScope = TestScope(testDispatcher)

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

        testCoroutinesScope.cancel()
    }

    @Test
    fun `get all characters when trying to load from server returns loading state`() {
        // AAA
        // Assign
        val stateList = mutableListOf<RickAndMortyState>()
        target.allCharacters.observeForever {
            stateList.add(it)
        }
        // Action
        target.getAllCharacters()

        // Assert
        assertThat(stateList).isNotEmpty()
        assertThat(stateList).hasSize(2)
        assertThat(stateList[0]).isInstanceOf(RickAndMortyState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(RickAndMortyState.LOADING::class.java)


    }
}