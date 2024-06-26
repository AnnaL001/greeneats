import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.feature)
}

android {
  namespace = "com.anna.greeneats.feature.auth"
}

dependencies {
  implementation(project(AndroidModules.Core.UI))
  implementation(project(AndroidModules.Core.UTIL))
}