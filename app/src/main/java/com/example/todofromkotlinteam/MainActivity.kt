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
        list.addAll(fileArras(resources.getStringArray(R.array.title),
            resources.getStringArray(R.array.content),
            resources.getStringArray(R.array.time),
            resources.getStringArray(R.array.name)))
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

    fun fileArras(titleArray:Array<String>, contentArray:Array<String>, timeArray:Array<String>, nameArray:Array<String>):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size - 1){
            var listItem = ListItem(titleArray[n],contentArray[n],timeArray[n],nameArray[n])
            listItemArray.add(listItem)
        }
        return  listItemArray
    }
}
