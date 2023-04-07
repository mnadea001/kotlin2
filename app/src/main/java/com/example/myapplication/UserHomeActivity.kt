package com.example.myapplication


import android.os.Bundle
import android.widget.TextView

class UserHomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        setHeaderTxt("Epsi")

        val textFirstName = findViewById<TextView>(R.id.textFirstName)
        textFirstName.text = (application as KotlinApplication).readSharedPref("firstName")
        val textLastName = findViewById<TextView>(R.id.textLastName)
        textLastName.text = (application as KotlinApplication).readSharedPref("lastName")
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