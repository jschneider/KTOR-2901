import io.ktor.client.request.get
import kotlinx.coroutines.*

/**
 *
 */


fun main(): Unit = runBlocking {
  while (true) {
    val response = Ktor2901Client.httpClient.get<String>("http://localhost:8080/test")
    println(response)

    delay(1000)
  }
}
