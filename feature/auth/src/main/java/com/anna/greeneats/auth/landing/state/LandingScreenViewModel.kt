package com.anna.greeneats.auth.landing.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.anna.greeneats.data.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LandingScreenViewModel @Inject constructor(
  private val authRepository: AuthRepository
) : ViewModel() {
  private val _landingScreenState = mutableStateOf(LandingScreenState())

  val landingScreenState get() = _landingScreenState as State<LandingScreenState>

  init {
    initNavigation()
  }

  private fun initNavigation(){
    val isLoggedIn = authRepository.isLoggedIn
    val isVerified = authRepository.isVerified

    if (isLoggedIn && isVerified == true) {
      handleNavigation(LandingScreenNavigation.NAVIGATE_TO_HOME)
      return
    }

    // Disable automatic Firebase login upon signup until user is verified
    authRepository.logout()
    handleNavigation(LandingScreenNavigation.NAVIGATE_TO_LOGIN)
  }

  private fun handleNavigation(navigation: LandingScreenNavigation){
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
