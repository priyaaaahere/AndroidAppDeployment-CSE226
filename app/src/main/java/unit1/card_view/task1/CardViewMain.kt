package unit1.card_view.task1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R

class CardViewMain : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_view_main)
        recyclerView=findViewById(R.id.recycleview)

        val items=listOf(
            TeamItems("India","Position: 1",R.drawable.india,36,4471,124),
            TeamItems("New Zealand","Position: 2",R.drawable.newzealand,38,4160, 109),
            TeamItems("Australia","Position: 3",R.drawable.australia, 32, 3473, 109),
            TeamItems("Sri Lanka","Position: 4",R.drawable.srilanka, 39, 4009, 103),
            TeamItems("Pakistan","Position: 5",R.drawable.pakistan, 34, 3465, 102),
            TeamItems("South Africa","Position: 6",R.drawable.southafrica, 29, 2775, 96),
            TeamItems("Afghanistan","Position: 7",R.drawable.afganistan, 25, 2279, 91),
            TeamItems("England","Position: 8",R.drawable.england, 34, 3003, 88),
            TeamItems("West Indies","Position: 9",R.drawable.westindies, 34, 2662, 78),
            TeamItems("Bangladesh","Position: 10",R.drawable.bangladesh, 32, 2465, 77)
        )
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = CardViewAdapter(items) { selectedItem ->
            Toast.makeText(this, "Clicked: ${selectedItem.name}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = adapter
    }
}