package com.example.todofromkotlinteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class NewIventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_activity)
        window.statusBarColor = ContextCompat.getColor(this,R.color.main_orange)
        window.navigationBarColor = ContextCompat.getColor(this,R.color.main_orange)
    }
}