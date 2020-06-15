package dev.oscarnylander.tddsample

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.apollographql.apollo.ApolloClient
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4::class)
class ExampleActivityTest : KoinTest {
    private val apolloClient: ApolloClient by inject()

    @get:Rule
    val activityRule = ActivityTestRule(ExampleActivity::class.java)

    @Before
    fun setup() {
        apolloClient.clearNormalizedCache()
    }

    @Test
    fun shouldShowLoadingSpinnerInitially() {
        onScreen<ExampleScreen> {
            loadingSpinner { isVisible() }
        }
    }
}
