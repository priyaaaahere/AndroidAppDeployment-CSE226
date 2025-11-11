package unit1.custom_list_view.task2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cse226_etp.R
import kotlin.jvm.java

class AdapterCustomCompanies(
    private val context: Context,
    private val companyCategories: List<CompanyCategory>
) : BaseAdapter() {

    override fun getCount(): Int = companyCategories.size

    override fun getItem(position: Int): Any = companyCategories[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.custom_company_list_item, parent, false)

        val category = companyCategories[position]

        val logo = view.findViewById<ImageView>(R.id.companyLogo)
        val name = view.findViewById<TextView>(R.id.companyName)

        logo.setImageResource(category.logo)
        name.text = category.name

        view.setOnClickListener {
            val intent = Intent(context, CustomCompanyMain::class.java)
            intent.putExtra("CATEGORY_NAME", category.name)
            context.startActivity(intent)
        }

        return view
    }
}
data class CompanyCategory(val name: String, val logo: Int)
