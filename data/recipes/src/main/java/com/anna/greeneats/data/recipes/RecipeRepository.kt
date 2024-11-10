package com.anna.greeneats.data.recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.RecipeSearch
import com.anna.greeneats.model.recipes.edamam_api.RecipesSearch

interface RecipeRepository {
  suspend fun fetchRecipes(
    dishType: List<String> ?= listOf(),
    mealType: List<String> ?= listOf(),
    cuisineType: List<String> ?= listOf(),
    diet: List<String> ?= listOf(),
    health: List<String> ?= listOf()
  ): Resource<RecipesSearch>

  suspend fun fetchRecipe(
    recipeId: String
  ): Resource<RecipeSearch>
}
