package com.example.myapplication


import android.os.Bundle
import android.widget.EditText

class UserHomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        setHeaderTxt("Epsi")

        val editTextFirstName = findViewById<EditText>(R.id.editTextFirstName)
        editTextFirstName.setText((application as KotlinApplication).readSharedPref("firstName"))
        val editTextLastName = findViewById<EditText>(R.id.editTextLastName)
        editTextLastName.setText((application as KotlinApplication).readSharedPref("lastName"))
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        editTextAddress.setText((application as KotlinApplication).readSharedPref("address"))
        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        editTextCity.setText((application as KotlinApplication).readSharedPref("city"))
        val editPostalAddress = findViewById<EditText>(R.id.editPostalAddress)
        editPostalAddress.setText((application as KotlinApplication).readSharedPref("postalAddress"))
        val editTextTextEmailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress)
        editTextTextEmailAddress.setText((application as KotlinApplication).readSharedPref("email"))
        val editTextLoyaltyCard = findViewById<EditText>(R.id.editTextLoyaltyCard)
        editTextLoyaltyCard.setText((application as KotlinApplication).readSharedPref("loyaltyCard"))

    }
}