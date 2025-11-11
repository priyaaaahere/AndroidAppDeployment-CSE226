package unit1.custom_list_view.task1

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R
import kotlin.jvm.java

class CustomListViewMain : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view_main)

        listView = findViewById(R.id.listView)
        val myItems=listOf(
            PlayerModel("India","#1",R.raw.anthem_india,R.drawable.india,"Cricket Team",3f),
            PlayerModel("New Zealand","#2",R.raw.anthem_india,R.drawable.newzealand,"Cricket Team",4f),
            PlayerModel("Australia","#3",R.raw.anthem_india,R.drawable.australia,"Cricket Team",5f),
            PlayerModel("Sri Lanka","#4",R.raw.anthem_india,R.drawable.srilanka,"Cricket Team",6f),
            PlayerModel("Pakistan","#5",R.raw.anthem_india,R.drawable.pakistan,"Cricket Team",7f),
            PlayerModel("South Africa","#6",R.raw.anthem_india,R.drawable.southafrica,"Cricket Team",8f),
            PlayerModel("Afghanistan","#7",R.raw.anthem_india,R.drawable.afganistan,"Cricket Team",9f),
            PlayerModel("England","#8",R.raw.anthem_india,R.drawable.england,"Cricket Team",10f),
            PlayerModel("West Indies","#9",R.raw.anthem_india,R.drawable.westindies,"Cricket Team",11f),
            PlayerModel("Bangladesh","#10",R.raw.anthem_india,R.drawable.bangladesh,"Cricket Team",12f)
        )
        val adapter = CustomListViewAdapter(this, myItems)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = myItems[position]
            val intent= Intent(this, TeamSelected::class.java)
            intent.putExtra("player", item)
            startActivity(intent)
        }

    }
}