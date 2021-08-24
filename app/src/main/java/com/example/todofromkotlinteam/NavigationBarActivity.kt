package com.example.todofromkotlinteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todofromkotlinteam.plans.PlansFragment
import com.example.todofromkotlinteam.ideas.IdeasFragment
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import kotlinx.android.synthetic.main.navigation_bar_activity.*

class NavigationBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_bar_activity)

        showWelcomeActivityIfNeeded()
        configureNavigationBar()
//        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }


    private fun showWelcomeActivityIfNeeded() {
        val value = SharedPreferencesManager.getBoolValueFor(SharedPreferencesKey.WELCOME_ACTIVITY_WAS_SHOWN, this)

        if (value != true) {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivityForResult(intent, 2)
            SharedPreferencesManager.setBoolValueFor(SharedPreferencesKey.WELCOME_ACTIVITY_WAS_SHOWN, true, this)
        }
    }

    private fun configureNavigationBar() {
        navigationView.menu.getItem(2).isEnabled = false
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, PlansFragment(this)).commit()

        navigationView.setOnNavigationItemSelectedListener { item ->
            var seletedFragment: Fragment? = null

            when (item.itemId) {
                R.id.plan -> seletedFragment = PlansFragment(this)
                R.id.ideas -> seletedFragment = IdeasFragment(this)
                R.id.profile -> seletedFragment = ProfileFragment(this)
                R.id.settings -> seletedFragment = SettingsFragment(this)
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, seletedFragment!!).commit()

            true
        }
    }
}
