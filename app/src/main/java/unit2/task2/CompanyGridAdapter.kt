package unit2.task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cse226_etp.R

class CompanyGridAdapter(
    private val context: Context,
    private val companies: List<Company>
) : BaseAdapter() {

    override fun getCount(): Int = companies.size

    override fun getItem(position: Int): Any = companies[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.company_card_item, parent, false)

        val company = companies[position]

        val logo = view.findViewById<ImageView>(R.id.companyLogo)
        val name = view.findViewById<TextView>(R.id.companyName)
        val location = view.findViewById<TextView>(R.id.companyLocation)

        logo.setImageResource(company.logo)
        name.text = company.name
        location.text = company.location

        return view
    }
}

data class Company(val name: String, val logo: Int, val location: String)
