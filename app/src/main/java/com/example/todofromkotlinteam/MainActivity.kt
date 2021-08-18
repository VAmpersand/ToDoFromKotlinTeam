package com.example.todofromkotlinteam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWelcomeActivityIfNeeded()
    }

    private fun showWelcomeActivityIfNeeded() {
//        val manager = SharedPreferencesManager()
        val value = getBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivityForResult(intent, 2)

           setBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, true)
        }
    }

    val title = "ToDoSharedPreferences"

    fun setBoolValueFor(key: SharedPreferencesKey, value: Boolean) {
        val pref: SharedPreferences = getSharedPreferences(title, Context.MODE_PRIVATE)
        val editor = pref?.edit()
        editor?.putBoolean(key.toString(), value)
        editor?.apply()
    }

    fun getBoolValueFor(key: SharedPreferencesKey): Boolean? {
        val pref: SharedPreferences = getSharedPreferences(title, Context.MODE_PRIVATE)
        return pref?.getBoolean(key.toString(), false)
    }
}
