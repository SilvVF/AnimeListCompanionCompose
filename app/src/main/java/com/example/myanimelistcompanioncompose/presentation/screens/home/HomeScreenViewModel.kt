package com.example.myanimelistcompanioncompose.presentation.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myanimelistcompanioncompose.data.remote.api.response.top_anime_models.JikanResponse
import com.example.myanimelistcompanioncompose.domain.model.AnimeShowData
import com.example.myanimelistcompanioncompose.domain.repository.JikanRepository
import com.example.myanimelistcompanioncompose.presentation.navigation.Route
import com.example.myanimelistcompanioncompose.util.Resource
import com.example.myanimelistcompanioncompose.util.UiEvent
import com.example.myanimelistcompanioncompose.util.toAnimeShowData

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
   private val jikanRepository: JikanRepository
): ViewModel(){

    init {
        loadTopAnimeList()
    }

    private var _topAnimeList = mutableStateOf<List<AnimeShowData>>(listOf())
    val topAnimeList = _topAnimeList

    private var pageNumber = 1

    fun loadTopAnimeList() = viewModelScope.launch {
        val response = jikanRepository.getTopAnimeList(
            filter = "upcoming",
            type = "tv",
            page = pageNumber
        )
        handleResponse(response)
    }

    private fun handleResponse(response: Resource<JikanResponse>) {
        when (response) {
            is Resource.Success -> {
                _topAnimeList.value += response.data?.data!!.map {
                    it.toAnimeShowData()
                }
            }
            else -> {}
        }
    }

    private val _uiEvent = Channel<UiEvent>()
    //exposed ui event
    val uiEvent = _uiEvent.receiveAsFlow() //triggered once for every event


    fun onCardClick(){
        viewModelScope.launch {
            _uiEvent.send(UiEvent.Navigate(Route.VIEW_ANIME_DETAILS)) //navigate to next screen
        }
    }
}