import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.data)
}

android {
  namespace = "com.anna.greeneats.data.auth"
}

dependencies {
  implementation(project(AndroidModules.Core.MODEL))
  implementation(platform(libs.firebase.bom))
  implementation(libs.firebase.auth)
}