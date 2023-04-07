package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val buttonLogin=findViewById<Button>(R.id.registrationBtn)
        buttonLogin.setOnClickListener(View.OnClickListener {
                val intent= Intent(application,RegisterActivity::class.java)
                startActivity(intent)
            })


    }
}