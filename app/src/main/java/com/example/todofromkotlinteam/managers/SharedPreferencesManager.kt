package com.example.todofromkotlinteam.managers

import android.content.Context
import android.content.SharedPreferences
import android.view.View

enum class SharedPreferencesKey {
    WelcomeActivityWasShown
}

class SharedPreferencesManager(context: Context) {
    private val title = "ToDoSharedPreferences"
    private var preferences: SharedPreferences? = null

    init {
        preferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
    }

    fun setBoolValueFor(key: SharedPreferencesKey, value: Boolean) {
        val editor = preferences?.edit()
        editor?.putBoolean(key.toString(), value)
        editor?.apply()
    }

    fun getBoolValueFor(key: SharedPreferencesKey): Boolean? {
        return preferences?.getBoolean(key.toString(), false)
    }

    fun resetSharedPreferences(){
        val editor = preferences?.edit()
        editor?.clear()
        editor?.apply()
    }
}
