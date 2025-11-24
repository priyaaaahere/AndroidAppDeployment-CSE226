package unit5.geoAndReverseGeoCoding

import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R
import java.util.Locale

class GeoReverseGeoCodingMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_geo_reverse_geo_coding_main)

        val geoButton = findViewById<Button>(R.id.geoButton)
        val reverseGeobtn=findViewById<Button>(R.id.reverseGeoButton)
        val addressInput=findViewById<EditText>(R.id.addressInput)
        val outputText=findViewById<TextView>(R.id.outputText)
        val geocoder=Geocoder(this, Locale.getDefault())

        //GeoCoding-Get coordinates from address
        geoButton.setOnClickListener{
            val address=addressInput.text.toString()
            if(address.isNotEmpty()){
                val location=geocoder.getFromLocationName(address,1)
                if(!location.isNullOrEmpty()){
                    val lat=location[0].latitude
                    val long=location[0].longitude
                    outputText.text="Latitude: $lat\nLongitude: $long"
                }
                else{
                    outputText.text="NO LOCATION FOUND"
                }
            }
            else{
                Toast.makeText(this, "Enter an address", Toast.LENGTH_SHORT).show()
            }
        }
        reverseGeobtn.setOnClickListener {
            try{
                val lat=28.61399
                val long=77.2090
                val address=geocoder.getFromLocation(lat,long,1)
                if(!address.isNullOrEmpty()){
                    val address=address[0].getAddressLine(0)
                    outputText.text="Address: $address"
                }
                else{
                    outputText.text="NO ADDRESS FOUND"
                }
            }
            catch (e:Exception){
                e.printStackTrace()
                outputText.text="Error: ${e.message}"
            }
        }
    }
}