package com.example.myapplication


import android.os.Bundle

class UserHomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        setHeaderTxt("Epsi")
    }
}