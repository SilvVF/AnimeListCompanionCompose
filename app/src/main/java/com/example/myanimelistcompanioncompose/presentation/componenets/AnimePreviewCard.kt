package com.example.myanimelistcompanioncompose.presentation.componenets

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transition.Transition
import coil.transition.TransitionTarget
import com.example.myanimelistcompanioncompose.R
import com.example.myanimelistcompanioncompose.presentation.navigation.Route
import com.example.myanimelistcompanioncompose.util.UiEvent
import kotlin.reflect.KFunction0

@Composable
fun AnimePreviewCard(
    onClick: KFunction0<Unit>,
    animeName: String,
    animeImage: String,
    animeKanji: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            }
            .shadow(10.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp,
    ) {
            CoilImage(
                url = animeImage,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Row(
                    Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.surface)
                        .padding(8.dp)) {
                    Text(
                        text = "$animeName - $animeKanji",
                        style = TextStyle(color = MaterialTheme.colors.onSurface, fontSize = 12.sp),
                    )
                }
            }

    }

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CoilImage(
    url: String,
    modifier: Modifier
) {
    val painter = rememberImagePainter(
        data = url,
        builder = {
            placeholder(R.drawable.loading_azurlane)
            error(R.drawable.anime_error)
        }
    )
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}