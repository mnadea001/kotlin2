package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //(application as KotlinApplication).clearSharedPref()
        if( (application as KotlinApplication).readSharedPref("firstName") != "" ){
            val intent = Intent(this, UserHomeActivity::class.java)
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val buttonLogin=findViewById<Button>(R.id.registrationBtn)
        buttonLogin.setOnClickListener(View.OnClickListener {
                val intent= Intent(application,RegisterActivity::class.java)
                startActivity(intent)
        })
        val buttonQrCode=findViewById<Button>(R.id.qrCodeGenerator)
        buttonQrCode.setOnClickListener(View.OnClickListener {
            val intent= Intent(application,CodebarActivity::class.java)
            startActivity(intent)
        })


    }
}