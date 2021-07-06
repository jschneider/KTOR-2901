plugins {
  kotlin("jvm") version "1.5.20"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(KotlinX.coroutines.core)
  implementation(KotlinX.serialization.json)

  api(Ktor.server.core)
  api(Ktor.server.netty)
  api(Ktor.features.auth)
  api(Ktor.features.auth)
  api(Ktor.features.authJwt)
}
