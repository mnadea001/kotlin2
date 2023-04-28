package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.OfferAdapter
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class OfferActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offres)
        setHeaderTxt("Offres")
        showBack()
        showProfil()
        setFooter()

        val offres = arrayListOf<Offer>()

        val recyclerViewOffer= findViewById<RecyclerView>(R.id.recyclerViewOffres)
        recyclerViewOffer.layoutManager= LinearLayoutManager(this)
        val offerAdapter = OfferAdapter(offres)
        recyclerViewOffer.adapter =  offerAdapter
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val myRequestUrl = "https://www.ugarit.online/epsi/offers.json"
        val request = Request.Builder().url(myRequestUrl).cacheControl(CacheControl.FORCE_NETWORK).build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                if (data != null) {
                    val jsOffers = JSONObject(data)
                    val jsArrayOffer = jsOffers.getJSONArray("items")

                    for (i in 0 until jsArrayOffer.length()) {
                        val jsCategory = jsArrayOffer.getJSONObject(i)
                        val offre = Offer(
                            jsCategory.optString("name", "Not found"),
                            jsCategory.optString("description", "Not found"),
                            jsCategory.optString("picture_url", "Not found")
                        )
                        offres.add(offre)
                    }
                    runOnUiThread(Runnable {
                        offerAdapter.notifyDataSetChanged()
                    })
                }
            }
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread(Runnable {
                    Toast.makeText(application, e.message, Toast.LENGTH_SHORT).show()
                })
            }

        })
    }


}