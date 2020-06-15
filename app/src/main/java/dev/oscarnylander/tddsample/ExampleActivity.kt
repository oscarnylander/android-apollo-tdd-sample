package dev.oscarnylander.tddsample

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_example.*
import org.koin.android.viewmodel.ext.android.viewModel

class ExampleActivity : AppCompatActivity(R.layout.activity_example) {
    private val model: ExampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model.data.observe(this, Observer {  data ->
            data?.film?.title?.let { title ->
                film.text = title
            }
        })

        button.setOnClickListener {
            button
                .animate()
                .setDuration(500)
                .alpha(0f)
                .withEndAction {
                    viewShownAfterAnimation.isVisible = true
                }
                .start()
        }
    }
}
