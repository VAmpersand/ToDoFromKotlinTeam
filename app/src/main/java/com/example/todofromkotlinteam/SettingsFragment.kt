package com.example.todofromkotlinteam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todofromkotlinteam.managers.SharedPreferencesKey
import com.example.todofromkotlinteam.managers.SharedPreferencesManager
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.settings_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resetButton.setOnClickListener {
            SharedPreferencesManager.setBoolValueFor(SharedPreferencesKey.WELCOME_ACTIVITY_WAS_SHOWN,false, requireContext())
        }
    }
}