package unit5.googleMaps.task2

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
import com.google.android.gms.maps.model.MarkerOptions

class GoogleMapsListOfPlaces : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var locationListLayout: LinearLayout

    private val places = listOf(
        Pair("Punjab", LatLng(31.1471, 75.3412)),
        Pair("Rudhunga, Odisha", LatLng(21.1860, 86.6561)),
        Pair("Delhi", LatLng(28.6139, 77.2090)),
        Pair("Mumbai", LatLng(19.0760, 72.8777))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_google_maps_list_of_places)

        locationListLayout = findViewById(R.id.locationList)

        // Setup the map
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add markers for all places
        for ((name, latLng) in places) {
            mMap.addMarker(MarkerOptions().position(latLng).title(name))
        }

        // Move camera to India initially (zoomed out)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(23.0, 80.0), 5f))

        // Dynamically add clickable list items
        for ((name, latLng) in places) {
            val textView = TextView(this).apply {
                text = name
                textSize = 18f
                setPadding(16, 16, 16, 16)
                setOnClickListener {
                    // When clicked → zoom to that location and show marker title
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                }
            }
            locationListLayout.addView(textView)
        }
    }
}