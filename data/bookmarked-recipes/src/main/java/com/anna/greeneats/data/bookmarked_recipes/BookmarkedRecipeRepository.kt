package com.anna.greeneats.data.bookmarked_recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.Recipe
import com.anna.greeneats.model.saved_recipes.SavedRecipe

interface BookmarkedRecipeRepository {
  suspend fun writeBookmarkedRecipes(userId: String, recipe: Recipe): Resource<Boolean>
  suspend fun fetchBookmarkedRecipes(userId: String): Resource<List<SavedRecipe>>
  suspend fun fetchBookmarkedRecipe(userId: String, savedRecipeId: String): Resource<SavedRecipe>
}