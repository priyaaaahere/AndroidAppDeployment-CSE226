package unit5.googleMaps.task3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R

class StateDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_detail)

        val stateName = intent.getStringExtra("stateName")

        val stateTitle = findViewById<TextView>(R.id.stateTitle)
        val stateInfo = findViewById<TextView>(R.id.stateInfo)

        stateTitle.text = stateName

        // You can customize details for each state here
        val details = when (stateName) {
            "Punjab" -> "Capital: Chandigarh\nKnown for: Golden Temple, Bhangra, Food"
            "Tamil Nadu" -> "Capital: Chennai\nKnown for: Temples, Classical dance Bharatanatyam"
            "Delhi" -> "Capital of India\nKnown for: Red Fort, India Gate, Parliament"
            "Odisha" -> "Capital: Bhubaneswar\nKnown for: Jagannath Temple, Konark Sun Temple"
            "Uttar Pradesh" -> "Capital: Lucknow\nKnown for: Taj Mahal, Varanasi"
            "Bihar" -> "Capital: Patna\nKnown for: Nalanda University, Bodh Gaya"
            "Andhra Pradesh" -> "Capital: Amaravati\nKnown for: Tirupati Temple"
            "Kerala" -> "Capital: Thiruvananthapuram\nKnown for: Backwaters, Ayurveda"
            "Karnataka" -> "Capital: Bengaluru\nKnown for: IT Hub, Mysore Palace"
            "Maharashtra" -> "Capital: Mumbai\nKnown for: Bollywood, Gateway of India"
            "West Bengal" -> "Capital: Kolkata\nKnown for: Howrah Bridge, Durga Puja"
            "Rajasthan" -> "Capital: Jaipur\nKnown for: Forts, Palaces, Deserts"
            else -> "No information available."
        }

        stateInfo.text = details
    }
}
