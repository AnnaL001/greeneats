import com.anna.greeneats.constants.AndroidModules
import com.anna.greeneats.extensions.implementation
import com.anna.greeneats.extensions.libs

plugins {
  alias(libs.plugins.greeneats.convention.feature)
}

android {
  namespace = "com.anna.greeneats.feature.auth"
}

dependencies {
  implementation(project(AndroidModules.Core.UI))
  implementation(project(AndroidModules.Core.UTIL))
  implementation(project(AndroidModules.Core.MODEL))
  implementation(project(AndroidModules.Data.AUTH))
}