package unit2.task2

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse226_etp.R

class CoroutinesActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_coroutines_main)

        val listView = findViewById<ListView>(R.id.listViewMain)

        val categories = listOf(
            CompanyCategory("Android", R.drawable.android_logo),
            CompanyCategory("iOS", R.drawable.ios_logo),
            CompanyCategory("React", R.drawable.react_logo),
            CompanyCategory("Full Stack", R.drawable.full_stack_logo)
        )

        val adapter = AdapterCustomCompanies(this, categories)
        listView.adapter = adapter
    }
}