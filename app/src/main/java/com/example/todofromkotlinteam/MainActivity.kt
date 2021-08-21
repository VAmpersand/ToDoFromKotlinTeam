package com.example.todofromkotlinteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.managers.ListEvent
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import com.example.todofromkotlinteam.managers.adapterEvent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val event = ArrayList<ListEvent>()

        event.add(ListEvent(R.drawable.mini_circle_red, "Virtual Doctors' Appointment ",
            "Regular virtual catchup with the doctor...", "12:00 - 12:30",
            "Dr. Julian Adams"))
        event.add(ListEvent(R.drawable.mini_circle_blue, "Guided group meditation",
            "Group meditation session at the office", "13:00 - 13:30",
            "Yoga instructor"))
        event.add(ListEvent(R.drawable.mini_circle_green, "Sprint planning",
            "Catchup to plan for next week's sprint", "14:00 - 15:00",
            "Dev.Team"))
        event.add(ListEvent(R.drawable.mini_circle_dark_blue, "Evening. yoga session",
            "Home yoga session for slip.", "19:00 - 19:30",""))
        event.add(ListEvent(R.drawable.mini_circle_red, "Virtual Doctors' Appointment ",
            "Regular virtual catchup with the doctor...", "12:00 - 12:30",
            "Dr. Julian Adams"))
        event.add(ListEvent(R.drawable.mini_circle_blue, "Guided group meditation",
            "Group meditation session at the office", "13:00 - 13:30",
            "Yoga instructor"))
        event.add(ListEvent(R.drawable.mini_circle_green, "Sprint planning",
            "Catchup to plan for next week's sprint", "14:00 - 15:00",
            "Dev.Team"))
        event.add(ListEvent(R.drawable.mini_circle_dark_blue, "Evening. yoga session",
            "Home yoga session for slip.", "19:00 - 19:30",""))

        recyclerEvent.hasFixedSize()
        recyclerEvent.layoutManager = LinearLayoutManager(this)
        recyclerEvent.adapter = adapterEvent(event,this)

        showWelcomeActivityIfNeeded()
    }

    private fun showWelcomeActivityIfNeeded() {
        val value = SharedPreferencesManager.getBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, this)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivityForResult(intent, 2)
            SharedPreferencesManager.setBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, true, this)
        }
    }

//    fun onClickRestart(view: View) {
//        val manager = SharedPreferencesManager(this)
//        manager.setBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, false)
//    }
}
