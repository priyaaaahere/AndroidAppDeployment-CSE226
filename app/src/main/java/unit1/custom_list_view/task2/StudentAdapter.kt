package unit1.custom_list_view.task2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.activity.contextaware.ContextAware
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R

class StudentAdapter(
    private val context: Context,
    private val students: ArrayList<Student>
    ) : BaseAdapter(){
    override fun getItem(position: Int): Any=students[position]
    override fun getCount(): Int = students.size
    override fun getItemId(position: Int): Long=position.toLong()
    override fun getView(position:Int, convertView: View?,parent: ViewGroup):View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.student_item, parent, false)
            holder = ViewHolder(
                view.findViewById(R.id.tvName),
                view.findViewById(R.id.tvRoll),
                view.findViewById(R.id.tvDept)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val student = students[position]

        holder.tvName.text = student.name
        holder.tvRoll.text = "Roll: ${student.roll}"
        holder.tvDept.text = "Dept: ${student.course}"

        return view
    }
    class ViewHolder(
        val tvName: TextView,
        val tvRoll: TextView,
        val tvDept: TextView
    )
}