package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MagasinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magasin)
        val magasin = intent.getSerializableExtra("magasin") as Magasin
        setHeaderTxt(magasin.name)
        showBack()
        setFooter()
        val imageView = findViewById<ImageView>(R.id.img_magasin)
        val imageUrl = magasin.pictureStore
        Picasso.get().load(imageUrl).into(imageView)
        val textAdresse = findViewById<TextView>(R.id.text_adress)
        val textVille = findViewById<TextView>(R.id.text_ville)
        val textDescription = findViewById<TextView>(R.id.text_description)
        textAdresse.setText(magasin.address)
        textVille.setText(magasin.zipcode+" "+magasin.city)
        textDescription.setText(magasin.description)




    }
}