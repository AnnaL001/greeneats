package com.anna.greeneats.auth.landing.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingScreenViewModel @Inject constructor() : ViewModel() {
  private val _landingScreenState = mutableStateOf(LandingScreenState())

  val landingScreenState get() = _landingScreenState as State<LandingScreenState>


  fun handleNavigation(navigation: LandingScreenNavigation){
    when(navigation){
      LandingScreenNavigation.NAVIGATE_TO_LOGIN -> {
        _landingScreenState.value = _landingScreenState.value.copy(navigateToLogin = true)
      }

      LandingScreenNavigation.NAVIGATE_TO_HOME -> {
        _landingScreenState.value = _landingScreenState.value.copy(navigateToHome = true)
      }
    }
  }
}
