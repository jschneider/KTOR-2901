import kotlinx.coroutines.*

/**
 *
 */


fun main() {
  println("Starting client!")

  GlobalScope.launch {
    Ktor2901Client.runTests()
  }
}
