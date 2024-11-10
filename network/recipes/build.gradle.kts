import com.anna.greeneats.constants.AndroidModules
import java.util.Properties

plugins {
  alias(libs.plugins.greeneats.convention.data)
}

val apiProperties = Properties()
val apiPropertiesFile = rootProject.file("api.properties")

if (apiPropertiesFile.exists()) {
  apiPropertiesFile.inputStream().use { inputStream ->
    apiProperties.load(inputStream)
  }
}

val edamamAppId: String? = apiProperties.getProperty("EDAMAM_APP_ID")
val edamamApiKey: String? = apiProperties.getProperty("EDAMAM_API_KEY")

android {
  namespace = "com.anna.greeneats.network.recipes"

  defaultConfig {
    // Ensure myApiKey is non-null and then use it
    edamamAppId?.let {
      buildConfigField("String", "EDAMAM_APP_ID", "\"$it\"")
    }

    edamamApiKey?.let {
      buildConfigField("String", "EDAMAM_API_KEY", "\"$it\"")
    }
  }
}

dependencies {
  implementation(project(AndroidModules.Model.MAIN))
  implementation(project(AndroidModules.Model.RECIPES))
  implementation(libs.bundles.ktor)
  implementation(libs.slf4j.android)
}