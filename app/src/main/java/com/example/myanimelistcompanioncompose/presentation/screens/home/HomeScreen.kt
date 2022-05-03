package com.example.myanimelistcompanioncompose.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myanimelistcompanioncompose.presentation.componenets.AnimePreviewCard
import com.example.myanimelistcompanioncompose.presentation.screens.home.HomeScreenViewModel
import com.example.myanimelistcompanioncompose.util.UiEvent

@Composable
fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true){
        viewModel.uiEvent.collect { event -> //observes the uiEvents
            when(event){
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()){
        LazyColumn(
            modifier = Modifier
        ){
            items(viewModel.topAnimeList.value){ anime ->
                AnimePreviewCard(
                        onClick = viewModel::onCardClick,
                        animeName = anime.title ?: "",
                        animeImage = anime.images?.jpg?.image_url ?: "",
                        animeKanji = anime.title_japanese ?: "",
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .padding( bottom = 32.dp)
                 )
            }
        }
    }
}