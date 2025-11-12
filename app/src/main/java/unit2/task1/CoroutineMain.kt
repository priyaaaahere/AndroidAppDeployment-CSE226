package unit2.task1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.cse226_etp.R
import kotlin.getValue

class CoroutineMain : AppCompatActivity() {

    /*
        For this we need to add few things
        in versions and libraries and in dependencies

        in versions:
        coroutines = "1.7.3"
        lifecycle = "2.6.2"

        in librarries:
        coroutines-core = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version.ref = "coroutines" }
        coroutines-android = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-android", version.ref = "coroutines" }
        lifecycle-livedata = { module = "androidx.lifecycle:lifecycle-livedata-ktx", version.ref = "lifecycle" }
        lifecycle-viewmodel = { module = "androidx.lifecycle:lifecycle-viewmodel-ktx", version.ref = "lifecycle" }

        in dependencies:
        implementation(libs.coroutines.core)
        implementation(libs.coroutines.android)
        implementation(libs.lifecycle.livedata)
        implementation(libs.lifecycle.viewmodel)
     */

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coroutine_main)
        val resultText=findViewById<TextView>(R.id.resultText)
        val btnFetch=findViewById<Button>(R.id.btnFetch)

        viewModel.result.observe(this, Observer {
            resultText.text = it
        })


        btnFetch.setOnClickListener {
            viewModel.startWork()
        }
    }
}