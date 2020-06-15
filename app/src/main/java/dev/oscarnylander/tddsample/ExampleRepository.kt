package dev.oscarnylander.tddsample

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred

class ExampleRepository(
    private val apolloClient: ApolloClient
) {
    fun filmAsync() = apolloClient
        .query(FilmQuery())
        .toDeferred()
}