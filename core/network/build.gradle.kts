plugins {
  alias(libs.plugins.greeneats.convention.data)
}

android {
  namespace = "com.anna.greeneats.core.network"
}

dependencies {
  implementation(libs.bundles.ktor)
  implementation(libs.slf4j.android)
}