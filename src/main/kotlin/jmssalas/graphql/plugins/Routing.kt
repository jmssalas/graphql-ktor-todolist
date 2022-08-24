package jmssalas.graphql.plugins

import com.expediagroup.graphql.generator.extensions.print
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import jmssalas.graphql.KtorGraphQLController

fun Application.configureRouting() {
    val ktorGraphQLController = KtorGraphQLController()

    routing {
        post("graphql") {
            ktorGraphQLController.handle(this.call)
        }

        get("sdl") {
            call.respondText(ktorGraphQLController.getGraphQLSchema().print())
        }

        get("playground") {
            this.call.respondText(
                buildPlaygroundHtml(
                    "graphql", "subscriptions"
                ), ContentType.Text.Html
            )
        }
    }
}

private fun buildPlaygroundHtml(graphQLEndpoint: String, subscriptionsEndpoint: String) =
    Application::class.java.classLoader.getResource("graphql-playground.html")?.readText()
        ?.replace("\${graphQLEndpoint}", graphQLEndpoint)
        ?.replace("\${subscriptionsEndpoint}", subscriptionsEndpoint)
        ?: throw IllegalStateException("graphql-playground.html cannot be found in the classpath")
