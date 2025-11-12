package unit1.recycler_view.task1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R

class RecyclerMain : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_main)

        recyclerView=findViewById(R.id.recycleview)

        val items=listOf(
            MyItem("Apple",R.drawable.ic_launcher_background),
            MyItem("Banana",R.drawable.ic_launcher_background),
            MyItem("Orange",R.drawable.ic_launcher_background),
            MyItem("Mango",R.drawable.ic_launcher_background),
            MyItem("Grapes",R.drawable.ic_launcher_background),
            MyItem("Apple",R.drawable.ic_launcher_background),
            MyItem("Banana",R.drawable.ic_launcher_background),
            MyItem("Orange",R.drawable.ic_launcher_background),
            MyItem("Mango",R.drawable.ic_launcher_background),
            MyItem("Grapes",R.drawable.ic_launcher_background),
            MyItem("Apple",R.drawable.ic_launcher_background),
            MyItem("Banana",R.drawable.ic_launcher_background),
            MyItem("Orange",R.drawable.ic_launcher_background),
            MyItem("Mango",R.drawable.ic_launcher_background),
            MyItem("Grapes",R.drawable.ic_launcher_background),
            MyItem("Apple",R.drawable.ic_launcher_background),
            MyItem("Banana",R.drawable.ic_launcher_background),
            MyItem("Orange",R.drawable.ic_launcher_background),
            MyItem("Mango",R.drawable.ic_launcher_background),
            MyItem("Grapes",R.drawable.ic_launcher_background),
            MyItem("Apple",R.drawable.ic_launcher_background),
            MyItem("Banana",R.drawable.ic_launcher_background),
            MyItem("Orange",R.drawable.ic_launcher_background),
            MyItem("Mango",R.drawable.ic_launcher_background),
            MyItem("Grapes",R.drawable.ic_launcher_background)
        )

        recyclerView.layoutManager= LinearLayoutManager(this)

        val adapter= RecyclerAdapter(items) { item ->
            Toast.makeText(this, "Clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter=adapter
    }
}