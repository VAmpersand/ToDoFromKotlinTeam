package com.example.todofromkotlinteam.plans.customCalendarView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.calendar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CustomCalendarView: LinearLayout {
    private val maxDays = 42
    private var parrentContext: Context? = null
    private val calendar = Calendar.getInstance(Locale.ENGLISH)
    private val titleDateFormat = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)
    private var dates: ArrayList<Date> = ArrayList()

    private lateinit var adapter: CustomCalendarGridAdapter

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        parrentContext = context
        initializeLayout()
        configureClendar()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun initializeLayout(){
        val inflater = parrentContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.calendar_layout,this)
    }

    private fun configureClendar(){
        currentDateTV.text = titleDateFormat.format(calendar.time)

        dates.clear()
        val monthCalendar = calendar.clone() as Calendar
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfMonth = monthCalendar.get(Calendar.DAY_OF_WEEK) - 1
        monthCalendar.add(Calendar.DAY_OF_MONTH, - firstDayOfMonth)

        while (dates.size < maxDays){
            dates.add(monthCalendar.time)
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        adapter = CustomCalendarGridAdapter(parrentContext!!, dates, calendar)
        gridView.adapter = adapter

        prevButton.setOnClickListener{
            calendar.add(Calendar.MONTH, -1)
            configureClendar()
        }

        nextButton.setOnClickListener{
            calendar.add(Calendar.MONTH, 1)
            configureClendar()
        }
        
    }
}