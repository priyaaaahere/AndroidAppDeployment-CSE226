package unit5.googleMaps.retrofit

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse226_etp.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import java.util.Locale
import kotlin.collections.isNotEmpty

/*
    Steps
    1. add dependency in build.gradle.kts and versions in libs.versions.toml (named as unit 5)
    2. add viewBinding = true in build.gradle.kts
    3. add permissions in AndroidManifest.xml
    4. add google maps api key in AndroidManifest.xml (will get it from google cloud console)
    5. create UserAdapter and item_user.xml
*/

interface ApiService {
    @GET("users")  // Example API endpoint
    fun getUsers(): Call<List<User>>
}

class APIcallsMain : AppCompatActivity(), OnMapReadyCallback {

    /*
        this gives access to the device location
        why not LocationManager? bcz, LocationManager is older way to handle maps and is not battery efficient
        FusedLocationProviderClient: It gives you access to the device’s location in a battery-efficient,
                                     high-accuracy way, by combining GPS, Wi-Fi, cell towers, and sensors.
    */

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var mMap: GoogleMap? = null

    // Views
    private lateinit var btnGetAddress: Button
    private lateinit var btnZoom: Button

    // to display data after api call
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_apicalls_main)

        // getting by id
        btnGetAddress = findViewById(R.id.btnGetAddress)
        btnZoom = findViewById(R.id.btnZoom)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // it is the gateway of location api. this will handle all the api calls for maps
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        /*
            supportFragmentManager → manages all fragments in AppCompatActivity.
            "as SupportMapFragment": The result of findFragmentById is a generic Fragment.
                                     We know it’s actually a SupportMapFragment (special class from Google Maps SDK), so we cast it.
            "mapFragment.getMapAsync(this)": Google Maps takes some time to load (because it connects to Play services, fetches tiles, etc). that is why we use async

        */
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Reverse Geocode Button → get address from the latitude and longitude
        // it will show the address of the current location in a toast
        btnGetAddress.setOnClickListener {

            getCurrentLocation { latLng ->
                val geocoder = Geocoder(this, Locale.getDefault())
                val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
                if (!addresses.isNullOrEmpty()) {
                    Toast.makeText(this, addresses[0].getAddressLine(0), Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Address not found", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Zoom to Current Location Button
        // it will zoom the map to the current location
        btnZoom.setOnClickListener {
            getCurrentLocation { latLng ->
                mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18f)) // 18f is the zoom level
            }
        }

        // Example API call
        RetrofitClient.api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()?.map {
                        // Fake conversion: using id as "Location X"
                        User(it.id, it.name, "Location ${it.id}")
                    } ?: emptyList()

                    recyclerView.adapter = UserAdapter(users)
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@APIcallsMain, "API Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap?.uiSettings?.isZoomControlsEnabled = true
        mMap?.uiSettings?.isMyLocationButtonEnabled = true
        mMap?.uiSettings?.isCompassEnabled = true
        mMap?.uiSettings?.isMapToolbarEnabled = true
        mMap?.uiSettings?.isRotateGesturesEnabled = true


        // ✅ Enable blue dot (my lccation)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap?.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
        }

        // ✅ Move camera to current location
        getCurrentLocation { latLng ->
            mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
        }

        // ✅ Listen for taps
        mMap?.setOnMapClickListener { latLng ->
            // Clear previous markers if needed
            mMap?.clear()

            // Add red marker at tapped location
            mMap?.addMarker(
                com.google.android.gms.maps.model.MarkerOptions()
                    .position(latLng)
                    .title("Selected Location")
            )

            // Reverse Geocode → get address
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

            if (addresses != null && addresses.isNotEmpty()) {
                val address = addresses[0].getAddressLine(0)
                Toast.makeText(this, address, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No address found", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun getCurrentLocation(onLocationFound: (LatLng) -> Unit) {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val latLng = LatLng(it.latitude, it.longitude)
                onLocationFound(latLng)
            }
        }
    }
}