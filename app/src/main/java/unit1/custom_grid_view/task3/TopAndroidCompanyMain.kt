package unit1.custom_grid_view.task3

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R

class TopAndroidCompanyMain : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var adapter: CompanyAdapter
    private lateinit var companyList: ArrayList<AndroidCompInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_android_company_main)

        gridView = findViewById(R.id.gridView)

        // Sample data (replace with real 20 companies)
        companyList = ArrayList()
        companyList.add(
            AndroidCompInfo(
                "Tech Mahindra",
                "A leading provider of IT services and solutions.",
                R.drawable.techmahindra
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Infosys",
                "Offers consulting, technology, and outsourcing services.",
                R.drawable.infosys
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Net Solutions",
                "Digital consulting & development company in Chandigarh.",
                R.drawable.netsolutions
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Novatr",
                "A leading provider of IT services and solutions.",
                R.drawable.novatr
            )
        )
        companyList.add(
            AndroidCompInfo(
                "TCS",
                "A leading provider of IT services and solutions.",
                R.drawable.tcs
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Wipro",
                "A leading provider of IT services and solutions.",
                R.drawable.wipro
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Accenture",
                "A leading provider of IT services and solutions.",
                R.drawable.accenture
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Cognizant",
                "A leading provider of IT services and solutions.",
                R.drawable.cognizant
            )
        )
        companyList.add(
            AndroidCompInfo(
                "HCL",
                "A leading provider of IT services and solutions.",
                R.drawable.hcl
            )
        )
        companyList.add(
            AndroidCompInfo(
                "Capgemini",
                "A leading provider of IT services and solutions.",
                R.drawable.capgemini
            )
        )


        adapter = CompanyAdapter(this, companyList)
        gridView.adapter = adapter
    }
}