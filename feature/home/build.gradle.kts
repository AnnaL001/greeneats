import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.library)
  alias(libs.plugins.greeneats.convention.compose.library)
}

android {
  namespace = "com.anna.greeneats.feature.home"
}

dependencies {
  implementation(project(AndroidModules.Core.UI))
}