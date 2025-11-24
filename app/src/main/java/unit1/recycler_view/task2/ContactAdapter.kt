package unit1.recycler_view.task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R

class ContactAdapter(
    private val items: List<MyItems>,
    private val onItemClick: (MyItems) -> Unit
): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.itemText)
        val textView2: TextView = itemView.findViewById(R.id.itemText2)
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.contactname
        holder.textView2.text = item.number

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Calling : ${item.contactname}", Toast.LENGTH_SHORT).show()
        }
    }
}
