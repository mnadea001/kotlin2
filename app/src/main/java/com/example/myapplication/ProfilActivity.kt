package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView

class ProfilActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        setHeaderTxt("Profil")
        showBack()

        val editTextFirstName=findViewById<EditText>(R.id.editTextFirstName)
        editTextFirstName.setText((application as KotlinApplication).readSharedPref("firstName"))
        val editTextLastName=findViewById<EditText>(R.id.editTextLastName)
        editTextLastName.setText((application as KotlinApplication).readSharedPref("lastName"))
        val editTextAddress=findViewById<EditText>(R.id.editTextAddress)
        editTextAddress.setText((application as KotlinApplication).readSharedPref("address"))
        val editTextCity=findViewById<EditText>(R.id.editTextCity)
        editTextCity.setText((application as KotlinApplication).readSharedPref("city"))
        val editPostalAddress=findViewById<EditText>(R.id.editPostalAddress)
        editPostalAddress.setText((application as KotlinApplication).readSharedPref("postAddress"))
        val editTextTextEmailAddress=findViewById<EditText>(R.id.editTextTextEmailAddress)
        editTextTextEmailAddress.setText((application as KotlinApplication).readSharedPref("email"))
        val editTextLoyaltyCard=findViewById<EditText>(R.id.editTextLoyaltyCard)
        editTextLoyaltyCard.setText((application as KotlinApplication).readSharedPref("loyaltyCard"))

        val signUpButtonSignUp=findViewById<Button>(R.id.updateButton)
        signUpButtonSignUp.setOnClickListener(View.OnClickListener {
            (application as KotlinApplication).writeSharedPref("firstName",editTextFirstName.text.toString())
            (application as KotlinApplication).writeSharedPref("lastName",editTextLastName.text.toString())
            (application as KotlinApplication).writeSharedPref("address",editTextAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("city",editTextCity.text.toString())
            (application as KotlinApplication).writeSharedPref("postAddress",editPostalAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("email",editTextTextEmailAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("loyaltyCard",editTextLoyaltyCard.text.toString())
            val intent= Intent(application,UserHomeActivity::class.java)
            startActivity(intent)

        })
    }
}