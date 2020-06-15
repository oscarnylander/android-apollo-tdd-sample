package dev.oscarnylander.tddsample

import androidx.test.espresso.IdlingRegistry
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.test.espresso.ApolloIdlingResource
import org.koin.android.ext.android.inject

class TestApp: App() {
    override val graphqlUrl = "http://localhost:8080"

    private val apolloClient: ApolloClient by inject()

    override fun onCreate() {
        super.onCreate()

        val idlingResource = ApolloIdlingResource.create("ApolloIdlingResource", apolloClient)
        IdlingRegistry
            .getInstance()
            .register(idlingResource)
    }
}