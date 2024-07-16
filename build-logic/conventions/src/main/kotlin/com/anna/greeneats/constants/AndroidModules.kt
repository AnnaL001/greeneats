package com.anna.greeneats.constants

object AndroidModules {
  object App{
    const val MOBILE = ":app:mobile"
  }

  object Features{
    const val HOME = ":feature:home"
    const val SAVED_RECIPES = ":feature:saved-recipes"
    const val COOKED_RECIPES = ":feature:cooked-recipes"
    const val AUTH = ":feature:auth"
    const val APP_SETTINGS = ":feature:app-settings"
  }

  object Core{
    const val NETWORK = ":core:network"
    // Reusable components
    const val UI = ":core:ui"
    // Data store
    const val LOCAL = ":core:local"
    // Utilities
    const val UTIL = ":core:util"
    // Navigation
    const val NAVIGATION = ":core:navigation"
    // Models
    const val MODEL = ":core:model"
  }

  object Data{
    const val RECIPES = ":data:home"
    const val SAVED_RECIPES = ":data:saved-recipes"
    const val COOKED_RECIPES = ":data:cooked-recipes"
    const val AUTH = ":data:auth"
    const val APP_SETTINGS = ":data:app-settings"
  }

  object Test{
    const val NAVIGATION = ":test:navigation"
    const val AUTH = ":test:auth"
  }
}