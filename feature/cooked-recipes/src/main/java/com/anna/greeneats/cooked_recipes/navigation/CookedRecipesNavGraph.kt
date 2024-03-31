package com.anna.greeneats.cooked_recipes.navigation

import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.anna.greeneats.cooked_recipes.CookedRecipesScreenInt

/**
 * Deep link and destinations navigated to within/from cooked recipes module
 */
fun NavGraphBuilder.addCookedRecipesNestedGraph(
    navController: NavHostController
) {
  navigation(startDestination = CookedRecipeRoutes.COOKED_RECIPES, route = CookedRecipeRoutes.ID) {
    composable(CookedRecipeRoutes.COOKED_RECIPES) { CookedRecipesScreen(
      onNavigateToRecipe = {
        val request = NavDeepLinkRequest.Builder
          .fromUri("android-app://com.anna.greeneats/recipe".toUri())
          .build()
        navController.navigate(request)
      }
    ) }
  }
}

@Composable
fun NavGraphBuilder.CookedRecipesScreen(onNavigateToRecipe: () -> Unit = {}) {
  CookedRecipesScreenInt(onNavigateToRecipe = onNavigateToRecipe)
}
