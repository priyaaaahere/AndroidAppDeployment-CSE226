package unit1.custom_list_view.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.cse226_etp.R

class CustomListViewAdapter(
    private val context: Context,
    private val items: List<PlayerModel>
) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)

    override fun getCount(): Int= items.size

    override fun getItem(position: Int): Any=items[position]

    override fun getItemId(position: Int): Long=position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.icc_custom_list, parent, false)
        val flagImage = rowView.findViewById<ImageView>(R.id.image)
        val teamName = rowView.findViewById<TextView>(R.id.name_of_team)
        val rankTeam = rowView.findViewById<TextView>(R.id.rank_of_team)
        val teamInfo = rowView.findViewById<TextView>(R.id.info_of_team)
        val teamRatings = rowView.findViewById<RatingBar>(R.id.ratingBar)
        val item = getItem(position) as PlayerModel
        flagImage.setImageResource(item.imageResId)
        teamName.text = item.name
        rankTeam.text = item.rank
        teamInfo.text = item.info
        teamRatings.rating = item.rating.toFloat()

        return rowView
    }
}