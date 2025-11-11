package unit1.custom_grid_view

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R

class GridMain : AppCompatActivity() {
    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid_main)

        gridView=findViewById(R.id.gridView)

        val items=listOf(
            GridItem("Apple", R.drawable.ic_launcher_background),
            GridItem("Banana", R.drawable.ic_launcher_background),
            GridItem("Orange", R.drawable.ic_launcher_background),
            GridItem("Mango", R.drawable.ic_launcher_background),
            GridItem("Grapes", R.drawable.ic_launcher_background),
            GridItem("Pineapple", R.drawable.ic_launcher_background)
        )
        val adapter= GridAdapter(this, items)
        gridView.adapter=adapter

        gridView.setOnItemClickListener {_,_,position, _ ->
            val item=items[position]
            Toast.makeText(this, "Clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }

    }
}