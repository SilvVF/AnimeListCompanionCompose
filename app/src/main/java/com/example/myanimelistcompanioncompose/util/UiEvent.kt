package com.example.myanimelistcompanioncompose.util

//define events to send from view models to composable
sealed class UiEvent {
    //navigate to route using  this
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackBar(val message: UiText): UiEvent()
}
