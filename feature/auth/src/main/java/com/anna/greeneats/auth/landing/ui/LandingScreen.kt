package com.anna.greeneats.auth.landing.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anna.greeneats.auth.landing.state.LandingScreenState
import com.anna.greeneats.core.ui.R
import kotlinx.coroutines.delay

@Composable
fun LandingScreen(
    landingScreenState: LandingScreenState = LandingScreenState(),
    onLoginNavigation: () -> Unit = {},
    onHomeNavigation: () -> Unit = {}
) {
  val delayMs: Long = 3000

  Column(
      modifier = Modifier.background(MaterialTheme.colorScheme.primary.copy(alpha = 0.05F)),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.loading_img),
            modifier = Modifier.size(88.dp),
            contentDescription = "",
            contentScale = ContentScale.FillBounds)

        LinearProgressIndicator(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.medium_padding)).width(88.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant)

    LaunchedEffect(landingScreenState.navigateToHome) {
      if(landingScreenState.navigateToHome){
        delay(delayMs)
        onHomeNavigation()
      }
    }

    LaunchedEffect(landingScreenState.navigateToLogin) {
      if(landingScreenState.navigateToLogin){
        delay(delayMs)
        onLoginNavigation()
      }
    }
   }
}
