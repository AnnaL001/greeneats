package com.anna.greeneats.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.anna.greeneats.auth.navigation.addAuthNestedGraph
import com.anna.greeneats.cooked_recipes.navigation.addCookedRecipesNestedGraph
import com.anna.greeneats.home.navigation.addHomeNestedGraph

/**
 * All possible destinations within the app
 */
@Composable
fun MainNavigation(navController: NavHostController = rememberNavController()) {
  NavHost(navController = navController, startDestination = AppRoutes.AUTH_FLOW) {
    addAuthNestedGraph(navController)
    addHomeNestedGraph(navController)
    addCookedRecipesNestedGraph(navController)
  }
}
