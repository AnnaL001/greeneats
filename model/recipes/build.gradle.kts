plugins {
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.greeneats.convention.library)
}

android {
  namespace = "com.anna.greeneats.model.recipes"
}

dependencies {
  implementation(libs.javax.annotation)
  implementation(libs.google.code.gson)
  implementation(libs.kotlinx.serialization.json)
}