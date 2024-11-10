package com.anna.greeneats.home.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anna.greeneats.data.auth.AuthRepository
import com.anna.greeneats.model.main.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  private val recipeRepository: com.anna.greeneats.data.recipes.RecipeRepository
) : ViewModel() {
  private val _homeState = mutableStateOf(HomeScreenState())
  val homeState
    get() = _homeState as State<HomeScreenState>

  init {
//    getRecipes()
  }

  private fun getRecipes() {
    viewModelScope.launch {
      when (val response = recipeRepository.fetchRecipes(dishType = listOf("Main course"))) {
        is Resource.Success -> {
          val mainCourseRecipes = RecipesCategory(
            title = "Main course",
            recipes = response.result.hits,
            errorMessage = ""
          )
          _homeState.value = _homeState.value.copy(mainCourseRecipes = mainCourseRecipes)
          Timber.d("Main course recipes total: ${mainCourseRecipes.recipes.size}")
          Timber.d("Main course first recipe: ${mainCourseRecipes.recipes[0]}")
        }

        is Resource.Failure -> {
          val maincourseRecipesError = RecipesCategory(
            recipes = listOf(),
            errorMessage = response.exception.message.toString()
          )
          _homeState.value.copy(mainCourseRecipes = maincourseRecipesError)
          Timber.e("Error getting main course recipe: ${maincourseRecipesError.errorMessage}")
        }
      }
    }
  }
}
