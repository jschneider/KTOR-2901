plugins {
  id("org.jetbrains.kotlin.multiplatform") version "1.5.20" apply false
  id("org.jetbrains.kotlin.plugin.serialization") version "1.5.20" apply false
  kotlin("js") version "1.5.20" apply false
  kotlin("jvm") version "1.5.20" apply false
}

repositories {
  mavenCentral()
}
