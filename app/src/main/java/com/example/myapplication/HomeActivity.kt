package com.example.myapplication

import android.os.Bundle
import android.widget.TextView

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val textViewTitle=findViewById<TextView>(R.id.textViewTitle)


    }
}