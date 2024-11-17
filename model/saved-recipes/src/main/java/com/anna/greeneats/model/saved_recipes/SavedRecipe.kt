package com.anna.greeneats.model.saved_recipes

import com.anna.greeneats.model.recipes.edamam_api.Recipe

data class SavedRecipe (
  val id: String = "",
  val edamamId: String = "",
  val recipe: Recipe = Recipe(),
  val status: String = RecipeStatus.INITIAL.name
)

enum class RecipeStatus {
  INITIAL,
  BOOKMARKED,
  COOKED
}