package com.example.todofromkotlinteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import kotlinx.android.synthetic.main.navigation_bar_activity.*

class NavigationBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_bar_activity)

        showWelcomeActivityIfNeeded()
        configureNavigationBar()
    }

    private fun showWelcomeActivityIfNeeded() {
        val value = SharedPreferencesManager.getBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, this)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivityForResult(intent, 2)
            SharedPreferencesManager.setBoolValueFor(SharedPreferencesKey.WelcomeActivityWasShown, true, this)
        }
    }

    private fun configureNavigationBar() {
        navigationView.background = null
        navigationView.menu.getItem(2).isEnabled = false

        navigationView.setOnNavigationItemSelectedListener { item ->
            var seletedFragment: Fragment? = null

            when (item.itemId) {
                R.id.plan -> seletedFragment = PlansFragment(this)
                R.id.ideas -> seletedFragment = IdeasFragment()
                R.id.profile -> seletedFragment = ProfileFragment()
                R.id.settings -> seletedFragment = SettingsFragment(this)
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, seletedFragment!!).commit()

            true
        }
    }
}
