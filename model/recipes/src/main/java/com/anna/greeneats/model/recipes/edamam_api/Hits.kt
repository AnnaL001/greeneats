package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable

@Serializable
data class Hits (
  var recipe : Recipe? = Recipe()
)