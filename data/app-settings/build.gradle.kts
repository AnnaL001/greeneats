import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.greeneats.convention.data)
}

android {
  namespace = "com.anna.greeneats.data.app_settings"
}

dependencies {
  implementation(project(AndroidModules.Model.MAIN))
  implementation(project(AndroidModules.Model.APP_SETTINGS))
  implementation(platform(libs.firebase.bom))
  implementation(libs.firebase.firestore)
}