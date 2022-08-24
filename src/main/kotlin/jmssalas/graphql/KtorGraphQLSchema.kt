package jmssalas.graphql

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.scalars.IDValueUnboxer
import com.expediagroup.graphql.generator.toSchema
import graphql.GraphQL
import jmssalas.graphql.schema.Query

class KtorGraphQLSchema {
    private val config = SchemaGeneratorConfig(supportedPackages = listOf("jmssalas.graphql"))
    private val queries = listOf(
        TopLevelObject(Query()),
    )
    private val mutations = listOf<TopLevelObject>()
    private val graphQLSchema = toSchema(config, queries, mutations)

    fun getGraphQLObject(): GraphQL = GraphQL.newGraphQL(graphQLSchema)
        .valueUnboxer(IDValueUnboxer())
        .build()
}