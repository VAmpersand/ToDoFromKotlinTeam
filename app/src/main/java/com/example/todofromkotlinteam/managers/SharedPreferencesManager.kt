package com.example.todofromkotlinteam.managers

import android.content.Context
import android.content.SharedPreferences
import android.view.View

enum class SharedPreferencesKey {
    WelcomeActivityWasShown
}

class SharedPreferencesManager(context: Context) {
    private val context = context
    private val title = "ToDoSharedPreferences"

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

    fun deleteAll(){
        val pref: SharedPreferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
        val editor = pref?.edit()
        editor?.clear()
        editor?.apply()
    }


}