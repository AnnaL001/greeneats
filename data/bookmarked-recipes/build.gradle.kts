import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.data)
}

android {
  namespace = "com.anna.greeneats.data.bookmarked_recipes"
}

dependencies {
  implementation(project(AndroidModules.Model.MAIN))
  implementation(project(AndroidModules.Model.RECIPES))
  implementation(project(AndroidModules.Model.SAVED_RECIPES))
  implementation(platform(libs.firebase.bom))
  implementation(libs.firebase.firestore)
}