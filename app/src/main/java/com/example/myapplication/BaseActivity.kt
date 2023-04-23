package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.Button
import android.content.Intent


open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setHeaderTxt(txt:String) {
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(txt)
    }

fun getTabbar(){
        val textViewTab1 = findViewById<Button>(R.id.textViewTab1)
        val textViewTab2 = findViewById<Button>(R.id.textViewTab2)
        val textViewTab3 = findViewById<Button>(R.id.textViewTab3)
        textViewTab1.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, QrCodeActivity::class.java)
            startActivity(intent)
        })
        textViewTab2.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, OffresActivity::class.java)
            startActivity(intent)
        })
        textViewTab3.setOnClickListener(View.OnClickListener {
            val intent = Intent(application, ShopsActivity::class.java)
            startActivity(intent)
        })}


/*    fun showBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }*/


}
