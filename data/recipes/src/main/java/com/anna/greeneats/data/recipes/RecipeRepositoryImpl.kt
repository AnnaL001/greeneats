package com.anna.greeneats.data.recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.RecipeSearch
import com.anna.greeneats.model.recipes.edamam_api.RecipesSearch
import com.anna.greeneats.network.recipes.EdamamApi
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val api: EdamamApi) : RecipeRepository {
  override suspend fun fetchRecipes(
    dishType: List<String> ?,
    mealType: List<String> ?,
    cuisineType: List<String> ?,
    diet: List<String> ?,
    health: List<String> ?
  ): Resource<RecipesSearch> {
    return api.getRecipes(dishType, mealType, cuisineType, diet, health)
  }

  override suspend fun fetchRecipe(recipeId: String): Resource<RecipeSearch> {
    return api.getRecipe(recipeId)
  }
}
