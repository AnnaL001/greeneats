package com.anna.greeneats.auth.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.anna.greeneats.auth.landing.ui.LandingScreenInt
import com.anna.greeneats.auth.login.ui.LoginScreenInt
import com.anna.greeneats.auth.signup.ui.SignUpScreenInt

/**
 * Feature flows and destinations navigated to within/from auth module
 */
fun NavGraphBuilder.addAuthNestedGraph(navController: NavController) {
  navigation(startDestination = AuthRoutes.LANDING, route = AuthRoutes.ID) {
    composable(AuthRoutes.LANDING) {
      LandingScreen(
        onNavigateToHome = { navController.navigate(AuthRoutes.HOME) },
        onNavigateToLogin = { navController.navigate(AuthRoutes.LOGIN) })
    }

    composable(AuthRoutes.LOGIN) {
      LoginScreen(
          onNavigateToSignup = { navController.navigate(AuthRoutes.SIGN_UP) },
          onNavigateToHome = { navController.navigate(AuthRoutes.HOME) })
    }

    composable(AuthRoutes.SIGN_UP) {
      SignUpScreen(onNavigateToLogin = { navController.navigate(AuthRoutes.LOGIN) })
    }
  }
}

@Composable
fun NavGraphBuilder.LoginScreen(onNavigateToSignup: () -> Unit = {}, onNavigateToHome: () -> Unit = {}) {
  LoginScreenInt(onNavigateToSignup = onNavigateToSignup, onNavigateToHome = onNavigateToHome)
}

@Composable
fun NavGraphBuilder.SignUpScreen(onNavigateToLogin: () -> Unit = {}) {
  SignUpScreenInt(onNavigateToLogin = onNavigateToLogin)
}

@Composable
fun NavGraphBuilder.LandingScreen(
    onNavigateToHome: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {
  LandingScreenInt(onNavigateToHome = onNavigateToHome, onNavigateToLogin = onNavigateToLogin)
}
