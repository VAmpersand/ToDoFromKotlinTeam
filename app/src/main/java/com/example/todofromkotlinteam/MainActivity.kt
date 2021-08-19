package com.example.todofromkotlinteam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWelcomeActivityIfNeeded()

    }

    private fun showWelcomeActivityIfNeeded() {
        val manager = SharedPreferencesManager(thi)
        val value = getBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivityForResult(intent, 2)

           setBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, true)
        }

    }

    fun onDeleteClick(view: View) {
        val value = SharedPreferencesManager(this).deleteAll()
    }

}
