plugins {
  alias(libs.plugins.greeneats.convention.library)
}

android {
  namespace = "com.anna.greeneats.core.util"
}

dependencies {
  // Kotlinx coroutines
  implementation(libs.kotlinx.coroutines)
}