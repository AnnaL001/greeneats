import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.library)
}

android {
  namespace = "com.anna.greeneats.model.saved_recipes"
}

dependencies {
  implementation(project(AndroidModules.Model.RECIPES))
}