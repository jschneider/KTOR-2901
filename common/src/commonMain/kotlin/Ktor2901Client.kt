import io.ktor.client.HttpClient
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.auth.providers.BearerTokens
import io.ktor.client.features.auth.providers.bearer
import io.ktor.client.request.post

/**
 * MPP ktor client implementation
 */
object Ktor2901Client {

  /**
   * HTTP client without authorization.
   * Is used to request the JWS token
   */
  val httpClientNoAuth: HttpClient = HttpClient {
  }

  val httpClient: HttpClient = HttpClient {
    install(Auth) {
      bearer {
        loadTokens {
          println("Loading JWS token")
          fetchJwsToken()
        }

        refreshTokens {
          println("Refreshing JWS token")
          fetchJwsToken()
        }
      }
    }
  }

  /**
   * Fetches a (new) JWS token
   */
  private suspend fun fetchJwsToken(): BearerTokens {
    val responseBody = httpClientNoAuth.post<String>("http://localhost:8080/auth") {
    }

    println("Authenticated successfully with token: <$responseBody>")
    return BearerTokens(responseBody, "????")
  }
}
