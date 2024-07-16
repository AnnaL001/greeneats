package com.anna.greeneats.auth.landing.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.anna.greeneats.auth.landing.state.LandingScreenViewModel

@Composable
internal fun LandingScreenInt(
    onNavigateToHome: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {
  val landingScreenModel = hiltViewModel<LandingScreenViewModel>()
  val landingState = landingScreenModel.landingScreenState.value

  LandingScreen(
      landingScreenState = landingState,
      onLoginNavigation = onNavigateToLogin,
      onHomeNavigation = onNavigateToHome)
}
