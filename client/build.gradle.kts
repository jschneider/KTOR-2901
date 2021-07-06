plugins {
  id("org.jetbrains.kotlin.plugin.serialization") version "1.5.20"
  kotlin("js") version "1.5.20"
}

repositories {
  mavenCentral()
}

kotlin {
  js {
    browser {
      runTask {

      }

      commonWebpackConfig {
        cssSupport.enabled = true
        mode = org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode.DEVELOPMENT
      }
    }
    binaries.executable()
  }
}

dependencies {
  implementation(KotlinX.coroutines.core)
  implementation(KotlinX.serialization.json)
  implementation(Ktor.client.json)
  implementation(Ktor.client.serialization)

  //React, React DOM + Wrappers (chapter 3)
  implementation("org.jetbrains.kotlin-wrappers:kotlin-react:_")
  implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:_")

  implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:_")

  //Table component
  implementation("org.jetbrains.kotlin-wrappers:kotlin-react-table:_")

  //State machine (with undo)
  implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:_")

  implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:_")
  implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:_")

  implementation("org.jetbrains.kotlin-wrappers:kotlin-css:_")
  implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:_")

  implementation(npm("react", "17.0.2"))
  implementation(npm("react-dom", "17.0.2"))
  implementation(npm("react-is", "17.0.2"))

  implementation(npm("styled-components", "~5.3.0"))

  implementation(npm("toastr", "^2.1.4"))
  implementation(npm("@material-ui/core", "^4.11.4"))
  implementation(npm("@material-ui/icons", "^4.11.2"))
}
