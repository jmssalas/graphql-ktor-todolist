package jmssalas.graphql

import com.expediagroup.graphql.server.execution.GraphQLServer
import io.ktor.server.request.*

class KtorGraphQLServer(
    requestParser: KtorGraphQLRequestParser,
    contextFactory: KtorGraphQLContextFactory,
    requestHandler: KtorGraphQLRequestHandler
): GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler)
