package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import android.view.View

class TabbarActivity : BaseActivity() {
    val tab1Fragment = QrCodeFragment.newInstance("", "")
    val tab2Fragment = ProductsFragment.newInstance("", "")
    val tab3Fragment = ShopsFragment.newInstance("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabbar)

        val textViewTab1 = findViewById<TextView>(R.id.textViewTab1)
        val textViewTab2 = findViewById<TextView>(R.id.textViewTab2)
        val textViewTab3 = findViewById<TextView>(R.id.textViewTab3)
        showTab2()
        textViewTab1.setOnClickListener(View.OnClickListener {
            showTab1()
        })
        textViewTab2.setOnClickListener(View.OnClickListener {
            showTab2()
        })
        textViewTab3.setOnClickListener(View.OnClickListener {
            showTab3()
        })
    }

    fun showTab1() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("QrCode")
        fragmentTransaction.replace(R.id.fragmentContent, tab1Fragment)
        fragmentTransaction.commit()
    }

    fun showTab2() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("Products")
        fragmentTransaction.replace(R.id.fragmentContent, tab2Fragment)
        fragmentTransaction.commit()
    }

    fun showTab3() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack("Shops")
        fragmentTransaction.replace(R.id.fragmentContent, tab3Fragment)
        fragmentTransaction.commit()
    }
}