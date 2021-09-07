package com.example.todofromkotlinteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.todofromkotlinteam.R.color
import kotlinx.android.synthetic.main.new_event_layout.*
import kotlinx.android.synthetic.main.plans_fragment.*


class NewEventActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_event_layout)
        window.statusBarColor = ContextCompat.getColor(this, color.main_orange)
        window.navigationBarColor = ContextCompat.getColor(this, color.main_orange)
        configureNewEvent()

    }

    private fun configureNewEvent() {
        nameEvent?.configureField(getString(R.string.name_event), null)
        typeEvent?.configureField(getString(R.string.type_event), null)
        dataEvent?.configureField(getString(R.string.date_event), null)
        startEvent?.configureField(getString(R.string.start_event), null)
        endEvent?.configureField(getString(R.string.end_event), null)
        describeEvent?.configureField(getString(R.string.describe_event), null)
        partnerEvent?.configureField(getString(R.string.partner_event), null)

    }

}

