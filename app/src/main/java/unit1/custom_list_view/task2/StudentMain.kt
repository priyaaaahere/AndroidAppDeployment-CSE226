package unit1.custom_list_view.task2

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R
import unit1.custom_listview.task2.StudentAdapter

class StudentMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_main)

        val listView=findViewById<ListView>(R.id.listViewStudents)

        val students=arrayListOf(
            Student("Priyadarshini", 101, "CSE"),
            Student("Meghana", 102, "CSE"),
            Student("Shashwat", 103, "CSE"),
            Student("Divyanshu",104,"CSE")
        )

        val adapter= StudentAdapter(this, students)
        listView.adapter=adapter

        listView.setOnItemClickListener{_,_,position,_->
            Toast.makeText(this,"Clicked on ${students[position].name}",Toast.LENGTH_LONG).show()

        }
    }
}