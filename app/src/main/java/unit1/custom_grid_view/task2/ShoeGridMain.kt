package unit1.custom_grid_view.task2

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R

class ShoeGridMain : AppCompatActivity() {
    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shoe_grid_main)

        gridView = findViewById(R.id.gridView1)

        val items = listOf(
            ShoeGridItem("Sports", R.drawable.ic_launcher_background, "2000", "Sports Shoes"),
            ShoeGridItem("Casual", R.drawable.ic_launcher_background, "1500", "Casual Shoes"),
            ShoeGridItem("Running", R.drawable.ic_launcher_background, "2500", "Running Shoes"),
            ShoeGridItem("Sneakers", R.drawable.ic_launcher_background, "1800", "Sneaker Shoes"),
            ShoeGridItem("Sandals", R.drawable.ic_launcher_background, "1200", "Sandals"),
            ShoeGridItem("Boots", R.drawable.ic_launcher_background, "3000", "Boots")
        )
        val adapter = ShoeAdapter(this, items)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val item = items[position]
            Toast.makeText(this, "Clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }

    }
}