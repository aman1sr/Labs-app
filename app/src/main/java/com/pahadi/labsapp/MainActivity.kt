package com.pahadi.labsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pahadi.labsapp.ui.CountryListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addFragmentToActivity(CountryListFragment())


    }
    private fun addFragmentToActivity(fragment: Fragment?){

        if (fragment == null) return

        val fm = supportFragmentManager
        val tr = fm.beginTransaction()
        tr.replace(R.id.framlayout, fragment)
        tr.commitAllowingStateLoss()
    }
}