package com.example.todofromkotlinteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.todofromkotlinteam.plans.PlansFragment
import com.example.todofromkotlinteam.ideas.IdeasFragment
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import kotlinx.android.synthetic.main.navigation_bar_activity.*
import kotlinx.android.synthetic.main.plans_fragment.*
import java.util.*

class NavigationBarActivity : AppCompatActivity() {
    private val plansFragment = PlansFragment(this)
    private val ideasFragment = IdeasFragment(this)
    private val profileFragment = ProfileFragment(this)
    private val settingsFragment = SettingsFragment(this)

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
            var seletedFragment: Fragment? = null

            when (item.itemId) {
                R.id.plan -> seletedFragment = plansFragment
                R.id.ideas -> seletedFragment = ideasFragment
                R.id.profile -> seletedFragment = profileFragment
                R.id.settings -> seletedFragment = settingsFragment
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, seletedFragment!!).commit()

            true
        }
    }

    fun updateFragment(calendar: Calendar) {
        plansFragment.weekView.configureWeek(calendar)
        Log.d("updateFragment", "updateFragment")
    }
}
