package com.example.todofromkotlinteam.managers

import android.content.Context

enum class SharedPreferencesKey {
    WelcomeActivityWasShown
}

object SharedPreferencesManager {
    private val title = "ToDoSharedPreferences"

    init {
        println("Singleton initialized")
    }

    fun setBoolValueFor(key: SharedPreferencesKey, value: Boolean, context: Context) {
        val preferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putBoolean(key.toString(), value)
        editor?.apply()
    }

    fun getBoolValueFor(key: SharedPreferencesKey, context: Context): Boolean? {
        val preferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
        return preferences?.getBoolean(key.toString(), false)
    }

    fun resetSharedPreferences(context: Context) {
        val preferences = context.getSharedPreferences(title, Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.clear()
        editor?.apply()
    }
}
