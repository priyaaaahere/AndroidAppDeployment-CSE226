package unit5.googleMaps.task1

import android.os.Bundle
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

class GoogleMapsMain : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps_main)
        // Go to Google Cloud Console and set the project firstly.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Example: Add a marker and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Location for Punjab, India (approximate center)
        val punjab = LatLng(31.1471, 75.3412)

        // Add a marker at Punjab and move the camera
        mMap.addMarker(MarkerOptions().position(punjab).title("Marker in Punjab"))

        // Marker 2: Rudhunga, Odisha
        val rudhunga = LatLng(21.1860, 86.6561)
        mMap.addMarker(MarkerOptions().position(rudhunga).title("Marker in Rudhunga, Odisha"))

//        mMap.moveCamera(
//            CameraUpdateFactory.newLatLngZoom(
//                punjab,
//                8f
//            )
//        ) // 8f is a good state-level zoom for the map.

        // Move the camera to your hometown (Rudhunga)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rudhunga, 10f))

    }
}
