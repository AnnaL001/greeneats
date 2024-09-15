import com.anna.greeneats.constants.AndroidModules
import java.util.Properties

plugins {
  alias(libs.plugins.greeneats.convention.data)
}

// Load api.properties file
val apiProperties = Properties()
val apiPropertiesFile = rootProject.file("api.properties")

if (apiPropertiesFile.exists()) {
  apiPropertiesFile.inputStream().use { inputStream ->
    apiProperties.load(inputStream)
  }
}

val googleClientId: String? = apiProperties.getProperty("GOOGLE_WEB_CLIENT_ID")

android {
  namespace = "com.anna.greeneats.data.auth"

  defaultConfig {
    // Ensure myApiKey is non-null and then use it
    googleClientId?.let {
      buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", "\"$it\"")
    }
  }
}

dependencies {
  implementation(project(AndroidModules.Core.MODEL))
  implementation(platform(libs.firebase.bom))
  implementation(libs.firebase.auth)
  implementation(libs.google.play)
  implementation(libs.androidx.credentials)
  implementation(libs.androidx.credentials.play)
  implementation(libs.identity.googleid)
  implementation(libs.androidx.junit.ktx)
  androidTestImplementation(libs.junit.junit)
}