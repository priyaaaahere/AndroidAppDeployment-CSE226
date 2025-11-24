package unit5.googleMaps.task3

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse226_etp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.jvm.java

class GoogleMapsAndStateDetailsMain : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var locationListLayout: LinearLayout
    private var currentMarker: Marker? = null  // To keep one marker only

    // Store places (name + coordinates)
    private val places = listOf(
        Pair("Punjab", LatLng(31.1471, 75.3412)),
        Pair("Tamil Nadu", LatLng(11.1271, 78.6569)),
        Pair("Delhi", LatLng(28.6139, 77.2090)),
        Pair("Odisha", LatLng(20.2376, 84.2700)),
        Pair("Uttar Pradesh", LatLng(27.5706, 80.0982)),
        Pair("Bihar", LatLng(25.9644, 85.2722)),
        Pair("Andhra Pradesh", LatLng(15.9129, 79.7400)),
        Pair("Kerala", LatLng(10.1632, 76.6413)),
        Pair("Karnataka", LatLng(15.3173, 75.71)),
        Pair("Maharashtra", LatLng(19.0760, 72.8777)),
        Pair("West Bengal", LatLng(22.9868, 87.8550)),
        Pair("Rajasthan", LatLng(27.0238, 74.2179))
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_google_maps_and_state_details_main)

        locationListLayout = findViewById(R.id.locationList)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(23.0, 80.0), 5f))

        // Add click listeners for each place name
        for ((name, latLng) in places) {
            val textView = TextView(this).apply {
                text = name
                textSize = 18f
                setPadding(16, 16, 16, 16)
                setOnClickListener {
                    // Remove old marker and add a new one
                    currentMarker?.remove()
                    currentMarker = mMap.addMarker(MarkerOptions().position(latLng).title(name))
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                }
            }
            locationListLayout.addView(textView)
        }

        // When marker is clicked → open new Activity
        mMap.setOnMarkerClickListener { marker ->
            val intent = Intent(this, StateDetailActivity::class.java)
            intent.putExtra("stateName", marker.title)
            startActivity(intent)
            true
        }
    }

}