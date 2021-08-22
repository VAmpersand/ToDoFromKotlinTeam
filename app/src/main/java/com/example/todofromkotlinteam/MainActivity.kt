package com.example.todofromkotlinteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.managers.ListItem
import com.example.todofromkotlinteam.managers.MyAdapter
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWelcomeActivityIfNeeded()

        val list = ArrayList<ListItem>()
        list.add(ListItem("Virtual Doctors’ Appointment","Regular virutal catchup with the doctor…","12:00 - 12:30","Dr. Juliean Adams"))
        list.add(ListItem("Guided group meditation","Group meditation session at the office ","13:00 - 13:30","Yoga instructor"))
        list.add(ListItem("Sprint planning ","Catchup to plan for next week’s sprint","14:00-15:00","Dev. Team "))
        list.add(ListItem("Evening. yoga session","Home yoga session for sleep.","19:00 - 19:30"," Dr. Juliean Adams"))
        list.add(ListItem("Virtual Doctors’ Appointment","Regular virutal catchup with the doctor…","12:00 - 12:30","Dr. Juliean Adams"))
        list.add(ListItem("Guided group meditation","Group meditation session at the office ","13:00 - 13:30","Yoga instructor"))
        list.add(ListItem("Sprint planning ","Catchup to plan for next week’s sprint","14:00-15:00","Dev. Team "))
        list.add(ListItem("Evening. yoga session","Home yoga session for sleep.","19:00 - 19:30"," Dr. Juliean Adams"))
        
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(list, this)
    }

    private fun showWelcomeActivityIfNeeded() {
        val manager = SharedPreferencesManager(this)
        val value = manager.getBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivityForResult(intent, 2)
            manager.setBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, true)
        }
    }

    fun onClickRestart(view: View) {
        SharedPreferencesManager(this).resetSharedPreferences()
    }
}
