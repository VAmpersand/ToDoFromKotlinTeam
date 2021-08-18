package com.example.todofromkotlinteam.managers

import android.content.Context
import android.content.SharedPreferences

enum class SharedPreferencesKey {
    WelcomeActivityWasShown
}

class SharedPreferencesManager(context: Context) {
    val context = context
    val title = "ToDoSharedPreferences"

    fun setBoolValueFor(key: SharedPreferencesKey, value: Boolean) {
        val pref: SharedPreferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
        val editor = pref?.edit()
        editor?.putBoolean("key.toString()", value)
        editor?.apply()
    }

    fun getBoolValueFor(key: SharedPreferencesKey): Boolean? {
        val pref: SharedPreferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
        return pref?.getBoolean("key.toString()", false)
    }

}