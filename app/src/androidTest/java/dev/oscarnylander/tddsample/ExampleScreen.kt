package dev.oscarnylander.tddsample

import com.agoda.kakao.common.views.KView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView

class ExampleScreen : Screen<ExampleScreen>() {
    val loadingSpinner =
        KView { withId(R.id.loadingSpinner) }
    val film =
        KTextView { withId(R.id.film) }
    val button = KButton { withId(R.id.button) }
    val viewShownAfterAnimation = KView { withId(R.id.viewShownAfterAnimation) }
}