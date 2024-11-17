package com.anna.greeneats.data.cooked_recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.Recipe
import com.anna.greeneats.model.saved_recipes.SavedRecipe
import com.google.firebase.firestore.CollectionReference

interface CookedRecipesRepository {
  suspend fun addCookedRecipe(userId: String, recipe: Recipe): Resource<Boolean>
  suspend fun fetchCookedRecipes(userId: String): Resource<List<SavedRecipe>>
  suspend fun fetchCookedRecipe(userId: String, savedRecipeId: String): Resource<SavedRecipe>
}