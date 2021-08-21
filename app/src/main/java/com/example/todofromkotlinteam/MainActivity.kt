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

<<<<<<< Updated upstream
        val list = ArrayList<ListItem>()
        list.addAll(fileArras(resources.getStringArray(R.array.title),
            resources.getStringArray(R.array.content),
            resources.getStringArray(R.array.time),
            resources.getStringArray(R.array.name)))
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(list, this)
=======
        var list = ArrayList<ListItem>()
        list.add(ListItem("Virtual Doctors’ Appointment","Regular virutal catchup with the doctor…","12:00 - 12:30","Dr. Juliean Adams"))
        list.add(ListItem("Guided group meditation","Group meditation session at the office ","13:00 - 13:30","Yoga instructor"))
        list.add(ListItem("Sprint planning ","Catchup to plan for next week’s sprint","14:00-15:00","Dev. Team "))
        list.add(ListItem("Evening. yoga session","Home yoga session for sleep.","19:00 - 19:30"," Dr. Juliean Adams"))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list,this)
>>>>>>> Stashed changes
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

    fun fileArras(titleArray:Array<String>, contentArray:Array<String>, timeArray:Array<String>, nameArray:Array<String>):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size - 1){
            var listItem = ListItem(titleArray[n],contentArray[n],timeArray[n],nameArray[n])
            listItemArray.add(listItem)
        }
        return  listItemArray
    }
}
