package com.example.myapplication


import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder

class UserHomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        setHeaderTxt("Epsi")
        showProfil()
        setFooter()

        val textName = findViewById<TextView>(R.id.textFirstName)

        val firstName = (application as KotlinApplication).readSharedPref("firstName")
        val lastName = (application as KotlinApplication).readSharedPref("lastName")

        textName.text = "$firstName $lastName"

        val barcodeVue = (application as KotlinApplication).readSharedPref("loyaltyCard")

        val barcodeData = findViewById<ImageView>(R.id.barcodeData)


        val writer : MultiFormatWriter = MultiFormatWriter();
        try {
            val matrix : BitMatrix = writer.encode(barcodeVue, BarcodeFormat.CODABAR, 800, 400)
            val encoder = BarcodeEncoder()
            val bitmap : Bitmap = encoder.createBitmap(matrix);
            barcodeData.setImageBitmap(bitmap)
        } catch (e : WriterException) {
            e.printStackTrace()
        }


/*        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        editTextAddress.setText((application as KotlinApplication).readSharedPref("address"))
        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        editTextCity.setText((application as KotlinApplication).readSharedPref("city"))
        val editPostalAddress = findViewById<EditText>(R.id.editPostalAddress)
        editPostalAddress.setText((application as KotlinApplication).readSharedPref("postalAddress"))
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        editTextTextEmailAddress.setText((application as KotlinApplication).readSharedPref("email"))
        val editTextLoyaltyCard = findViewById<EditText>(R.id.editTextLoyaltyCard)
        editTextLoyaltyCard.setText((application as KotlinApplication).readSharedPref("loyaltyCard"))*/

    }
}