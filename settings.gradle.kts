pluginManagement {
  repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  }
}

plugins {
  id("de.fayard.refreshVersions") version "0.10.1"
}

include("server")
include("client")
