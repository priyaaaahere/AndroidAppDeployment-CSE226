package unit6.expressoTesting.task2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R

class EspressoTesting2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_espresso_testing2)
        val nameField = findViewById<EditText>(R.id.editTextName)
        val button = findViewById<Button>(R.id.btnShow)
        val result = findViewById<TextView>(R.id.textResult)

        button.setOnClickListener {
            val text = nameField.text.toString()
            result.text = "Hello, $text"
        }
    }
}