package com.example.todofromkotlinteam.plans

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import kotlinx.android.synthetic.main.calendar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

public class CustomCalendarView: LinearLayout {
    private val maxDays = 42
    private val calendar = Calendar.getInstance(Locale.ENGLISH)
    private var days: ArrayList<Date> = ArrayList()
    private var evants: ArrayList<ListEvent> = ArrayList()
    private var parrentContext: Context? = null
    private val titleDateFormat = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        parrentContext = context

        initializeLayout()

        prevButton.setOnClickListener {
            calendar.add(Calendar.MONTH, -1)
            configureCalendar()
        }

        nextButton.setOnClickListener {
            calendar.add(Calendar.MONTH, 1)
            configureCalendar()
        }
    }


    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    private fun initializeLayout() {
        val inflater = parrentContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.calendar_layout, this)
    }

    private fun configureCalendar() {
        currentDateTitle.text = titleDateFormat.format(calendar.time)
    }
}