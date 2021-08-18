package com.example.todofromkotlinteam.managers

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

enum class SharedPreferencesKey {
    WelcomeActivityWasShown
}

sealed class SharedPreferencesManager : Activity() {
    val title = "ToDoSharedPreferences"

    fun setBoolValueFor(key: SharedPreferencesKey, value: Boolean) {
        val pref: SharedPreferences = getSharedPreferences(title, Context.MODE_PRIVATE)
        val editor = pref?.edit()
        editor?.putBoolean("key.toString()", value)
        editor?.apply()
    }

    fun getBoolValueFor(key: SharedPreferencesKey): Boolean? {
        val pref: SharedPreferences = getSharedPreferences(title, Context.MODE_PRIVATE)
        return pref?.getBoolean("key.toString()", false)
    }
}