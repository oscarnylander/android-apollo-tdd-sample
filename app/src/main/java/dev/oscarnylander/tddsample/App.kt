package dev.oscarnylander.tddsample

import android.app.Application
import com.apollographql.apollo.ApolloClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

open class App: Application() {
    open val graphqlUrl = "https://swapi-graphql.netlify.app/.netlify/functions/index"

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                module {
                    single { ApolloClient.builder().serverUrl(graphqlUrl).build() }
                    single { ExampleRepository(get()) }
                    viewModel { ExampleViewModel(get()) }
                }
            )
        }
    }
}