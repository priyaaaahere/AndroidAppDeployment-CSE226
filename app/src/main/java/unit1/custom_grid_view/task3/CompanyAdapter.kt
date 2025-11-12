package unit1.custom_grid_view.task3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.cse226_etp.R

class CompanyAdapter(private val context: Context, private val companyList: ArrayList<AndroidCompInfo>) : BaseAdapter() {

    override fun getCount(): Int = companyList.size

    override fun getItem(position: Int): Any = companyList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.company_grid_item, parent, false)

        val companyImage = view.findViewById<ImageView>(R.id.companyImage)
        val companyName = view.findViewById<TextView>(R.id.companyName)
        val companyAbout = view.findViewById<TextView>(R.id.companyAbout)

        val company = companyList[position]

        companyImage.setImageResource(company.imageResId)
        companyName.text = company.name
        companyAbout.text = company.about

        return view
    }
}
