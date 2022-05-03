package com.example.myanimelistcompanioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myanimelistcompanioncompose.presentation.componenets.AnimePreviewCard
import com.example.myanimelistcompanioncompose.presentation.navigation.Route
import com.example.myanimelistcompanioncompose.presentation.navigation.navigate
import com.example.myanimelistcompanioncompose.presentation.screens.HomeScreen
import com.example.myanimelistcompanioncompose.presentation.ui.theme.MyAnimeListCompanionComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAnimeListCompanionComposeTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.HOME
                    ){
                        composable(route = Route.HOME){
                            HomeScreen(
                                onNavigate = {

                                }
                            )
                        }
                        composable(route = Route.VIEW_ANIME_DETAILS){

                        }
                        composable(route = Route.SEARCH){

                        }
                    }

                }

            }
        }
    }
}
