import com.anna.greeneats.constants.AndroidModules

plugins {
  alias(libs.plugins.gms)
  alias(libs.plugins.greeneats.convention.application)
  alias(libs.plugins.greeneats.convention.compose.application)
}

android {
  namespace = "com.anna.greeneats.app.mobile"

  defaultConfig {
    applicationId = "com.anna.greeneats.app.mobile"
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables { useSupportLibrary = true }
  }



  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }

}

dependencies{
  implementation(project(AndroidModules.Core.UI))
  implementation(project(AndroidModules.Core.NAVIGATION))
}
