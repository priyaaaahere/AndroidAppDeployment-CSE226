package unit1.recycler_view.task2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R

class ContactMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleview)

        val items=listOf(
            MyItems("Priya","9876543210"),
            MyItems("Shashwat","9140062947"),
            MyItems("Meghu","6348936592"),
            MyItems("Ishaant","9876543210"),
            MyItems("Divu","9140062947"),
            MyItems("Yousuf","9609362692"),
            MyItems("Prince","9876543210"),
            MyItems("Aditya","8346944923"),
            MyItems("Aryan","7483649204"),
            MyItems("Abhishek","9609362692"),
            MyItems("Mujtaba","9426047070"),
            MyItems("Somee","8903747240"),
            MyItems("Anupam","8970482034")
        )
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter= ContactAdapter(items) { item ->
            Toast.makeText(this,"Clicked: ${item.contactname}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter=adapter
    }
}
