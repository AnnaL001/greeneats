import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.feature)
}

android {
  namespace = "com.anna.greeneats.feature.home"
}

dependencies {
  implementation(project(AndroidModules.Core.UI))
  implementation(project(AndroidModules.Data.RECIPES))
  implementation(project(AndroidModules.Data.AUTH))
  implementation(project(AndroidModules.Model.MAIN))
  implementation(project(AndroidModules.Model.RECIPES))
}