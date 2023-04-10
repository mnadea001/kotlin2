package com.example.myapplication


import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import android.graphics.Bitmap
import android.widget.TextView
import android.util.Log
import android.widget.Toast
import android.graphics.Color
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException

private const val TAG = "UserHomeActivity"

class UserHomeActivity : BaseActivity() {
    val text = "null"
    private lateinit var b1: MaterialButton
    private lateinit var e1: TextInputEditText
    private lateinit var i1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        setHeaderTxt("Epsi")

        val textFirstName = findViewById<TextView>(R.id.textFirstName)
        textFirstName.text = (application as KotlinApplication).readSharedPref("firstName")
        val textLastName = findViewById<TextView>(R.id.textLastName)
        textLastName.text = (application as KotlinApplication).readSharedPref("lastName")

        b1 = findViewById(R.id.b1) as MaterialButton
        e1 = findViewById(R.id.e1) as TextInputEditText
        i1 = findViewById(R.id.i1) as ImageView

        b1.setOnClickListener{
            val text = e1.text.toString().trim()
            if(text.trim().isEmpty()){

                Toast.makeText(this,"Empty",3000).show()

            }else{

                val bitmap = generateQRCode(text.trim())
                i1.setImageBitmap(bitmap)
            }
        }
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