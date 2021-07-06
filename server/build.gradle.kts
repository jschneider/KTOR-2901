plugins {
  kotlin("jvm")
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

  testImplementation(project(":common"))
  testImplementation(Ktor.client.apache)
}
