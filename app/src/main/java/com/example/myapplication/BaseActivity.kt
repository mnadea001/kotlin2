package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setHeaderTxt(txt:String) {
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.setText(txt)
    }

    open fun showBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    open fun showProfil(){
        val imageViewProfil=findViewById<ImageButton>(R.id.buttonProfil)
        imageViewProfil.visibility= View.VISIBLE
        imageViewProfil.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ProfilActivity::class.java)
            startActivity(intent)
        })
    }
    open fun setFooter() {

        val buttonMagasin = findViewById<Button>(R.id.button_magasin)
        buttonMagasin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        })

        val buttonOffre = findViewById<Button>(R.id.button_offre)
        buttonOffre.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, OfferActivity::class.java)
            startActivity(intent)
        })
    }

    fun containsOnlyDigits(str: String): Boolean {
        return str.matches(Regex("\\d+"))
    }

/*    fun showBack(){
        val imageViewBack=findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility= View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }*/


}
