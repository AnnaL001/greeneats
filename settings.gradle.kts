pluginManagement {
  includeBuild("build-logic")
  repositories {
    google {
      content {
        includeGroupByRegex("com\\.android.*")
        includeGroupByRegex("com\\.google.*")
        includeGroupByRegex("androidx.*")
      }
    }
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  @Suppress("UnstableApiUsage")
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

  @Suppress("UnstableApiUsage")
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "GreenEats"

include(":app:mobile")
include(":core:ui")
include(":core:navigation")
include(":core:util")

include(":data:auth")
include(":data:recipes")

include(":feature:home")
include(":feature:auth")
include(":feature:cooked-recipes")

include(":model:main")
include(":model:recipes")

include(":network:recipes")

