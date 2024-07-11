package com.anna.greeneats.auth.landing.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anna.greeneats.auth.landing.state.LandingScreenViewModel

@Composable
internal fun LandingScreenInt(
    onNavigateToHome: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {},
    landingScreenModel: LandingScreenViewModel = viewModel()
) {
  val landingState = landingScreenModel.landingScreenState.value

  LandingScreen(
    landingScreenState = landingState,
    onLoginNavigation = onNavigateToLogin,
    onHomeNavigation = onNavigateToHome
  )
}
