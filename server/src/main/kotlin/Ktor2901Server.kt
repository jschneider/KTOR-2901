import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.auth.jwt.JWTPrincipal
import io.ktor.auth.jwt.jwt
import io.ktor.features.CORS
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.time.Instant
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit
import java.util.Date

/**
 *
 */

fun main() {
  println("Starting up the server")

  embeddedServer(Netty, 8081, module = {
    launch()
  }).start(wait = true)
}

val secretKey: Algorithm = Algorithm.HMAC256("TheSecretSecret")

internal fun Application.launch() {
  println("Starting server")

  install(Authentication) {
    jwt("jwt-auth") {
      realm = "ktor2019"

      verifier(
        JWT
          .require(secretKey)
          .build()
      )

      validate { credential ->
        JWTPrincipal(credential.payload)
      }
    }
  }

  install(CORS) {
    host("localhost:8080")
    header(HttpHeaders.Authorization)

    allowNonSimpleContentTypes = true

    methods += HttpMethod.Patch
    methods += HttpMethod.Post
    methods += HttpMethod.Put
  }

  routing {
    route("auth") {
      post {
        val notBefore = Instant.now()
        val expiration = notBefore.plus(5, ChronoUnit.SECONDS)

        val jws = JWT.create()
          .withNotBefore(notBefore.toDate())
          .withExpiresAt(expiration.toDate())
          .sign(secretKey)

        println("Valid until ${expiration.atZone(ZoneOffset.UTC)}. Token: $jws")
        call.respondText(jws)
      }
    }

    authenticate("jwt-auth") {
      route("test") {
        get {
          call.respondText("Hello World!")
        }
      }
    }
  }
}

fun Instant.toDate(): Date {
  return Date(this.toEpochMilli())
}
