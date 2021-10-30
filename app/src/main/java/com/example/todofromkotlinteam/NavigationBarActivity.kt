package com.example.todofromkotlinteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.todofromkotlinteam.plansList.PlansFragment
import com.example.todofromkotlinteam.ideasList.IdeasFragment
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import com.example.todofromkotlinteam.views.customCalendarView.OnCalendarClickListener
import com.example.todofromkotlinteam.views.weekView.OnWeekTopClickListener
import kotlinx.android.synthetic.main.date_input_dialog_layout.*
import kotlinx.android.synthetic.main.navigation_bar_activity.*
import java.util.*



class NavigationBarActivity : AppCompatActivity(), OnCalendarClickListener, OnWeekTopClickListener
    {
    private val plansFragment = PlansFragment()
    private val ideasFragment = IdeasFragment()
    private val profileFragment = ProfileFragment()
    private val settingsFragment = SettingsFragment()

    var currentCalendar = Calendar.getInstance(Locale.ENGLISH)!!
    var selectedDate = Date()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_bar_activity)

        showWelcomeActivityIfNeeded()
        configureNavigationBar()
    }

    private fun showWelcomeActivityIfNeeded() {
        val value = SharedPreferencesManager.getBoolValueFor(SharedPreferencesKey.WELCOME_ACTIVITY_WAS_SHOWN, this)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)

            SharedPreferencesManager.setBoolValueFor(SharedPreferencesKey.WELCOME_ACTIVITY_WAS_SHOWN, true, this)
        }
    }

    private fun configureNavigationBar() {
        navigationView.menu.getItem(2).isEnabled = false
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, plansFragment).commit()

        navigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.plan -> selectedFragment = plansFragment
                R.id.ideas -> selectedFragment = ideasFragment
                R.id.profile -> selectedFragment = profileFragment
                R.id.settings -> selectedFragment = settingsFragment
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, selectedFragment!!).commit()

            true
        }
    }

    fun onClickAddEvent(view : View){
        val intent = Intent(this,NewEventActivity::class.java)
        startActivity(intent)
    }

    // MARK: - OnCalendarClickListener
    override fun onDateClickListener(date: Date) {
        selectedDate = date
        plansFragment.configureFragment()
        ideasFragment.configureFragment()
    }

    override fun onSetCalendarClickListener(calendar: Calendar) {
         this.currentCalendar = calendar
          Log.d("calendar","$currentCalendar")
        plansFragment.configureFragment()
        ideasFragment.configureFragment()
    }

    // MARK: - OnWeekTopClickListener
    override fun onWeekDateClickListener(date: Date) {
        currentCalendar.time = date
        selectedDate = date
        plansFragment.configureFragment()
        ideasFragment.configureFragment()
    }


}
