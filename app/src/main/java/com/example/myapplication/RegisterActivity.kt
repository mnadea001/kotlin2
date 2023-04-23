package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextFirstName=findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName=findViewById<EditText>(R.id.editTextLastName)
        val editTextAddress=findViewById<EditText>(R.id.editTextAddress)
        val editTextCity=findViewById<EditText>(R.id.editTextCity)
        val editPostalAddress=findViewById<EditText>(R.id.editPostalAddress)
        val editTextTextEmailAddress=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextLoyaltyCard=findViewById<EditText>(R.id.editTextLoyaltyCard)

        val signUpButtonSignUp=findViewById<Button>(R.id.signUpButtonSignUp)
        signUpButtonSignUp.setOnClickListener(View.OnClickListener {
            (application as KotlinApplication).writeSharedPref("firstName",editTextFirstName.text.toString())
            (application as KotlinApplication).writeSharedPref("lastName",editTextLastName.text.toString())
            (application as KotlinApplication).writeSharedPref("address",editTextAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("city",editTextCity.text.toString())
            (application as KotlinApplication).writeSharedPref("postAddress",editPostalAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("email",editTextTextEmailAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("loyaltyCard",editTextLoyaltyCard.text.toString())
            val intent= Intent(application,TabbarActivity::class.java)
            startActivity(intent)

        })


    }
}


