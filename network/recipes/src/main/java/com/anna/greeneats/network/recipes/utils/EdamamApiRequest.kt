package com.anna.greeneats.network.recipes.utils

import com.anna.greeneats.network.recipes.BuildConfig


sealed class EdamamApiRequest {
  object Endpoint {
    const val HOST = "api.edamam.com"

    const val RECIPES_SEARCH_URL = "api/recipes/v2"
  }

  object QueryParams {
    object RecipeType {
      const val TYPE_KEY = "type"
      const val TYPE_VALUE = "public"
    }

    object AppId {
      const val KEY = "app_id"
      const val VALUE = BuildConfig.EDAMAM_APP_ID
    }

    object ApiKey {
      const val KEY = "app_key"
      const val VALUE = BuildConfig.EDAMAM_API_KEY
    }

    object Recipe {
      const val QUERY_TEXT = "q"
      const val DIET_TYPE = "diet"
      const val HEALTH_LABEL = "health"
      const val CUISINE_TYPE = "cuisineType"
      const val MEAL_TYPE = "mealType"
      const val DISH_TYPE = "dishType"
    }
  }
}


