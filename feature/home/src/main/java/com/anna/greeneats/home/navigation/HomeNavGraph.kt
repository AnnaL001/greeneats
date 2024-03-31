package com.anna.greeneats.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.anna.greeneats.home.HomeScreenInt
import com.anna.greeneats.home.recipes_detail.RecipeDetailsScreenInt

/**
 * Feature flows and destinations navigated to within/from home module
 */
fun NavGraphBuilder.addHomeNestedGraph(navController: NavHostController) {
  navigation(startDestination = HomeRoutes.HOME, route = HomeRoutes.ID) {
    composable(HomeRoutes.HOME) {
      HomeScreen(
        onNavigateToRecipe = { navController.navigate(HomeRoutes.DETAIL) },
        onNavigateToCookedRecipes = { navController.navigate(HomeRoutes.COOKED_RECIPES)})
    }
    composable(
      route =  HomeRoutes.DETAIL,
      deepLinks = listOf(navDeepLink {
          uriPattern = "android-app://com.anna.greeneats/recipe"
        }
      )
    ) {
      RecipeDetailsScreen(onNavigateToHome = { navController.navigate(HomeRoutes.HOME) })
    }
  }
}

@Composable
fun NavGraphBuilder.HomeScreen(
  onNavigateToRecipe: () -> Unit = {},
  onNavigateToCookedRecipes: () -> Unit = {}) {
  HomeScreenInt(
    onNavigateToRecipe = onNavigateToRecipe,
    onNavigateToCookedRecipes = onNavigateToCookedRecipes)
}

@Composable
fun NavGraphBuilder.RecipeDetailsScreen(onNavigateToHome: () -> Unit = {}) {
  RecipeDetailsScreenInt(onNavigateToHome = onNavigateToHome)
}
