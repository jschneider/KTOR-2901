plugins {
  id("org.jetbrains.kotlin.multiplatform")
}


repositories {
  mavenCentral()
}

kotlin {
  jvm()
  js {
    browser {
    }
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        api(Kotlin.stdlib.common)

        implementation(KotlinX.coroutines.core)
        implementation(KotlinX.serialization.json)
        implementation(Ktor.client.json)
        implementation(Ktor.client.serialization)
        implementation(Ktor.client.auth)
      }
    }

    jvm().compilations["main"].defaultSourceSet {
      dependencies {
      }
    }
  }
}
