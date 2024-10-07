package com.anna.greeneats.core.network

sealed class EdamamApiRequest {
  object Endpoint {
    private const val BASE_URL = "https://api.edamam.com"

    const val RECIPES_SEARCH_URL = "${BASE_URL}/api/recipes/v2"
  }

  object QueryParams {
    object RecipeType {
      const val TYPE_KEY = "type"
      const val TYPE_VALUE = "public"
    }

    object App {
      const val ID = "app_id"
      const val KEY = "app_key"
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


