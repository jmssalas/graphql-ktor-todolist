package jmssalas.graphql

import com.expediagroup.graphql.dataloader.KotlinDataLoaderRegistryFactory
import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import graphql.GraphQL

class KtorGraphQLRequestHandler(
    graphQL: GraphQL,
    dataLoaderRegistryFactory: KotlinDataLoaderRegistryFactory? = null
): GraphQLRequestHandler(graphQL, dataLoaderRegistryFactory)
