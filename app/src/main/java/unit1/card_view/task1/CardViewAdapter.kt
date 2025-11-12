package unit1.card_view.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R

class CardViewAdapter(
    private val items: List<TeamItems>,
    private val onItemClick: (TeamItems) -> Unit
) : RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.name_of_team)
        val textView2: TextView = itemView.findViewById(R.id.info_of_team)
        val textView3: TextView = itemView.findViewById(R.id.matches)
        val textView4: TextView = itemView.findViewById(R.id.points)
        val textView5: TextView = itemView.findViewById(R.id.ratings)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_custom_team, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.textView.text = item.name
        holder.textView2.text = item.info
        holder.textView3.text = "Matches: ${item.matches}"
        holder.textView4.text = "Points: ${item.pts}"
        holder.textView5.text = "Ratings: ${item.ratings}"
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }
    override fun getItemCount(): Int = items.size
}
