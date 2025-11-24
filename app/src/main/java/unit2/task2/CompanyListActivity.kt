package unit2.task2

import android.os.Bundle
import android.widget.GridView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.cse226_etp.R

class CompanyListActivity : AppCompatActivity() {

    private val viewModel: Coroutine by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_company_list)

        val title = findViewById<TextView>(R.id.tvCategoryTitle)

        val categoryName = intent.getStringExtra("CATEGORY_NAME")?: ""
        viewModel.startWork(categoryName)
        viewModel.result.observe(this, Observer {
            title.text = it
        })


//        title.text = "Top 10 $categoryName"



        val gridView = findViewById<GridView>(R.id.GridViewCompanies)

        val companies = when (categoryName) {
            "Android" -> listOf(
                Company("Google", R.drawable.google_logo, "California, USA"),
                Company("Samsung", R.drawable.samsung_logo, "Seoul, South Korea")
            )
            "iOS" -> listOf(
                Company("Apple", R.drawable.ios_logo, "California, USA"),
                Company("IBM", R.drawable.ibm_logo, "New York, USA")
            )
            "React" -> listOf(
                Company("Meta", R.drawable.meta_logo, "California, USA"),
                Company("Netflix", R.drawable.netflix_logo, "California, USA")
            )
            "Full Stack" -> listOf(
                Company("Microsoft", R.drawable.microsoft_logo, "Washington, USA"),
                Company("Amazon", R.drawable.amazon_logo, "Seattle, USA")
            )
            else -> emptyList()
        }

        val adapter = CompanyGridAdapter(this, companies)
        gridView.adapter = adapter
    }
}