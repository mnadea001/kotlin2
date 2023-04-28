package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

internal class MapsActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    val magasins = arrayListOf<Magasin>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setHeaderTxt("Magasins")
        showBack()
        showProfil()
        setFooter()

    }

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestUrl = "https://www.ugarit.online/epsi/stores.json"
        val request = Request.Builder().url(mRequestUrl).cacheControl(CacheControl.FORCE_NETWORK).build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null) {
                    val jsMagasins = JSONObject(data)
                    val jsArrayMagasin = jsMagasins.getJSONArray("stores")
                    for (i in 0 until jsArrayMagasin.length()) {
                        val jsMagasin = jsArrayMagasin.getJSONObject(i)
                        val magasin = Magasin(
                            jsMagasin.optString("storeId", "Not found"),
                            jsMagasin.optString("name", "Not found"),
                            jsMagasin.optString("description", "Not found"),
                            jsMagasin.optString("pictureStore", "Not found"),
                            jsMagasin.optString("address", "Not found"),
                            jsMagasin.optString("zipcode", "Not found"),
                            jsMagasin.optString("city", "Not found"),
                            jsMagasin.optString("longitude", "Not found").toDouble(),
                            jsMagasin.optString("latitude", "Not found").toDouble()
                        )
                        magasins.add(magasin)
                        val magasinPosition = LatLng(magasin.latitude, magasin.longitude)
                        runOnUiThread {
                            mMap.addMarker(MarkerOptions()
                                .position(magasinPosition)
                                .title(magasin.name)
                                .snippet(magasin.address+" "+magasin.zipcode+" "+magasin.city))
                        }
                    }
                }

            }
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread(Runnable {
                    Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
                })
            }
        })

        val paris = LatLng(48.8566, 2.3522)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paris, 5f))

        mMap.setOnInfoWindowClickListener { marker ->
            val magasin: Magasin? = magasins.find { it.latitude == marker.position.latitude && it.longitude == marker.position.longitude }
            val intent = Intent(this, MagasinActivity::class.java).apply {
                putExtra("magasin", magasin )
            }
            startActivity(intent)
            true
        }



    }



}
