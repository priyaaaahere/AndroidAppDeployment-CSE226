package unit6.expressoTesting.task1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R
import unit6.unitTesting.task1.Calculator

class EspressoTaskMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_espresso_task_main)

        val num1=findViewById<EditText>(R.id.etNumber1)
        val num2=findViewById<EditText>(R.id.etNumber2)
        val btn=findViewById<Button>(R.id.btnAdd)
        val result=findViewById<TextView>(R.id.tvResult)


        btn.setOnClickListener {
            val a=num1.text.toString().toIntOrNull() ?:0
            val b=num2.text.toString().toIntOrNull() ?:0
            val res= Calculator().addition(a,b)
            result.text=res.toString()
        }
    }
}