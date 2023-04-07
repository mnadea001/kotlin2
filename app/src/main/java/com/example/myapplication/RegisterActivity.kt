package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextFirstName=findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName=findViewById<EditText>(R.id.editTextLastName)
        val editTextAddress=findViewById<EditText>(R.id.editTextAddress)
        val editTextCity=findViewById<EditText>(R.id.editTextCity)
        val editTextPhone=findViewById<EditText>(R.id.editTextPhone)
        val editTextTextEmailAddress=findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextTextPassword=findViewById<EditText>(R.id.editTextTextPassword)

        val signUpButtonSignUp=findViewById<Button>(R.id.signUpButtonSignUp)
        signUpButtonSignUp.setOnClickListener(View.OnClickListener {
            val txt=editTextFirstName.text.toString() +" / "+
                    editTextLastName.text.toString() +" / "+
                    editTextAddress.text.toString() +" / "+
                    editTextCity.text.toString() +" / "+
                    editTextPhone.text.toString() +" / "+
                    editTextTextEmailAddress.text.toString() +" / "+
                    editTextTextPassword.text.toString()

            Toast.makeText(application,txt,Toast.LENGTH_SHORT).show()
        })
    }
}