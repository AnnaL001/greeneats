package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable

@Serializable
data class RecipeSearch(
  var hit: Hits = Hits()
)
