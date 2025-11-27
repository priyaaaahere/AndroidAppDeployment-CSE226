package unit1.custom_listview.task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.cse226_etp.R
import unit1.custom_list_view.task2.Student

class StudentAdapter(
    private val context: Context,
    private val students: List<Student>
) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int = students.size

    override fun getItem(position: Int): Any = students[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = convertView ?: inflater.inflate(R.layout.student_item, parent, false)

        val tvName = rowView.findViewById<TextView>(R.id.tvName)
        val tvRoll = rowView.findViewById<TextView>(R.id.tvRoll)
        val tvDept = rowView.findViewById<TextView>(R.id.tvDept)

        val student = getItem(position) as Student

        tvName.text = student.name
        tvRoll.text = "Roll: ${student.roll}"
        tvDept.text = "Dept: ${student.course}"

        return rowView
    }
}
