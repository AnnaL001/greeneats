package com.anna.greeneats.home.state

import com.anna.greeneats.model.recipes.edamam_api.Hits

data class HomeScreenState(
  val activeUser: ActiveUser = ActiveUser(),
  val mainCourseRecipes: RecipesCategory = RecipesCategory()
)

data class ActiveUser(
  val username: String = "Guest",
  val profileImg: String = ""
)

data class RecipesCategory(
  val title: String = "",
  val recipes: List<Hits> = listOf(),
  val errorMessage: String = ""
)
