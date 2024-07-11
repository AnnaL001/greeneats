package com.anna.greeneats.auth.landing.state


data class LandingScreenState (
  val navigateToHome: Boolean = false,
  val navigateToLogin: Boolean = false
)
enum class LandingScreenNavigation {
  NAVIGATE_TO_HOME,
  NAVIGATE_TO_LOGIN
}
