import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.library)
  alias(libs.plugins.greeneats.convention.compose.library)
}

android {
  namespace = "com.anna.greeneats.core.navigation"
}

dependencies {
  implementation(project(AndroidModules.Core.UI))
  implementation(project(AndroidModules.Features.AUTH))
  implementation(project(AndroidModules.Features.HOME))
  implementation(project(AndroidModules.Features.COOKED_RECIPES))
}