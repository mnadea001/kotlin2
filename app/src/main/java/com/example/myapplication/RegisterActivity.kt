package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONObject

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val bundle : Bundle? = intent.extras



        val editTextFirstName=findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName=findViewById<EditText>(R.id.editTextLastName)
        val editTextAddress=findViewById<EditText>(R.id.editTextAddress)
        val editTextCity=findViewById<EditText>(R.id.editTextCity)
        val editPostalAddress=findViewById<EditText>(R.id.editPostalAddress)
        val editTextTextEmailAddress=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextLoyaltyCard=findViewById<EditText>(R.id.editTextLoyaltyCard)
        val signUpButtonSignUp=findViewById<Button>(R.id.signUpButtonSignUp)

        if(intent.hasExtra("json")) {

            val jsonObject = JSONObject(bundle?.getString("json").toString())
            editTextFirstName?.setText( jsonObject.getString("firstName"))
            editTextLastName?.setText( jsonObject.getString("lastName"))
            editTextAddress?.setText( jsonObject.getString("address"))
            editTextTextEmailAddress?.setText( jsonObject.getString("email"))
            editPostalAddress?.setText( jsonObject.getString("zipcode"))
            editTextCity?.setText( jsonObject.getString("city"))
            editTextLoyaltyCard?.setText( jsonObject.getString("cardRef"))

        }

        signUpButtonSignUp.setOnClickListener(View.OnClickListener {
            (application as KotlinApplication).writeSharedPref("firstName",editTextFirstName.text.toString())
            (application as KotlinApplication).writeSharedPref("lastName",editTextLastName.text.toString())
            (application as KotlinApplication).writeSharedPref("address",editTextAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("city",editTextCity.text.toString())
            (application as KotlinApplication).writeSharedPref("postAddress",editPostalAddress.text.toString())
            (application as KotlinApplication).writeSharedPref("email",editTextTextEmailAddress.text.toString())

            if (containsOnlyDigits(editTextLoyaltyCard.text.toString())) {
                (application as KotlinApplication).writeSharedPref("loyaltyCard",editTextLoyaltyCard.text.toString())
                val intent= Intent(application,UserHomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "La carte de fidélité ne doit pas contenir de lettres", Toast.LENGTH_SHORT).show()
            }
        })


    }
}


