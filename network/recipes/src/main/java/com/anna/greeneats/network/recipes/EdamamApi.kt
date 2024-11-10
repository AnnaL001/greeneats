package com.anna.greeneats.network.recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.RecipeSearch
import com.anna.greeneats.model.recipes.edamam_api.RecipesSearch
import com.anna.greeneats.network.recipes.utils.EdamamApiRequest
import com.anna.greeneats.network.recipes.utils.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import io.ktor.http.encodeURLQueryComponent
import javax.inject.Inject

class EdamamApi @Inject constructor(val client: HttpClient) {
  suspend fun getRecipes(
    dishType: List<String> ?= listOf(),
    mealType: List<String> ?= listOf(),
    cuisineType: List<String> ?= listOf(),
    diet: List<String> ?= listOf(),
    health: List<String> ?= listOf()
  ): Resource<RecipesSearch> = safeApiCall {
    client.get{
      url {
        if(dishType?.isNotEmpty() == true) {
          dishType.map { dish ->  encodedParameters.append(EdamamApiRequest.QueryParams.Recipe.DISH_TYPE, dish.encodeURLQueryComponent())}
        }

        if(mealType?.isNotEmpty() == true) {
          mealType.map { meal -> encodedParameters.append(EdamamApiRequest.QueryParams.Recipe.MEAL_TYPE, meal.encodeURLQueryComponent()) }
        }

        if(cuisineType?.isNotEmpty() == true) {
          cuisineType.map { cuisine -> encodedParameters.append(EdamamApiRequest.QueryParams.Recipe.CUISINE_TYPE, cuisine.encodeURLQueryComponent()) }
        }

        if(diet?.isNotEmpty() == true) {
          diet.map { dietType -> encodedParameters.append(EdamamApiRequest.QueryParams.Recipe.DIET_TYPE, dietType.encodeURLQueryComponent()) }
        }

        if(health?.isNotEmpty() == true) {
          health.map { healthType -> encodedParameters.append(EdamamApiRequest.QueryParams.Recipe.HEALTH_LABEL, healthType.encodeURLQueryComponent()) }
        }

      }
    }.body()
  }

  suspend fun getRecipe(
    recipeId: String
  ): Resource<RecipeSearch> = safeApiCall {
    client.get{
      url {
        appendPathSegments("v2", recipeId)
      }
    }.body()
  }
}