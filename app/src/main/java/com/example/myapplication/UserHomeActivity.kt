package com.example.myapplication


import android.os.Bundle
import android.graphics.Bitmap
import android.widget.TextView
import android.util.Log
import android.graphics.Color
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException

private const val TAG = "UserHomeActivity"

class UserHomeActivity : BaseActivity() {
    private lateinit var e1: TextView
    private lateinit var i1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        setHeaderTxt("Epsi")
        e1 = findViewById<TextView>(R.id.textFirstName)
        e1.text = (application as KotlinApplication).readSharedPref("firstName")
        val textLastName = findViewById<TextView>(R.id.textLastName)
        textLastName.text = (application as KotlinApplication).readSharedPref("lastName")

        val textLoyaltyCard = findViewById<TextView>(R.id.textLoyaltyCard)
        textLoyaltyCard.text = (application as KotlinApplication).readSharedPref("loyaltyCard")

        i1 = findViewById<ImageView>(R.id.i1)
        val text = e1.text.toString().trim()
        val bitmap = generateQRCode(text.trim())
        i1.setImageBitmap(bitmap)
    }

    private fun generateQRCode(text: String): Bitmap {
        val width = 150
        val height = 150
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val codeWriter = MultiFormatWriter()
        try {
            val bitMatrix =
                codeWriter.encode(text, BarcodeFormat.CODE_128, width, height)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    val color = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
                    bitmap.setPixel(x, y, color)
                }
            }
        } catch (e: WriterException) {

            Log.d(TAG, "generateQRCode: ${e.message}")

        }
        return bitmap
    }
}