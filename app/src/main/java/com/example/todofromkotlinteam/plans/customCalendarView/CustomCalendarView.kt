package com.example.todofromkotlinteam.plans.customCalendarView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import androidx.core.view.isVisible
import com.example.todofromkotlinteam.NavigationBarActivity
import kotlinx.android.synthetic.main.calendar_date_layout.view.*
import kotlinx.android.synthetic.main.calendar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CustomCalendarView: LinearLayout {
    private var calendar = Calendar.getInstance()
    private var dates: ArrayList<Date> = ArrayList()
    private val titleDateFormat = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)
    private lateinit var gridAdapter: CustomCalendarGridAdapter

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        initializeLayout()
        configureCalendar()
        configureListeners()
    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.calendar_layout, this)
    }

    fun configureCalendar() {
        val maxDays = 42
        calendar = (context as NavigationBarActivity).currentCalendar
        currentDateTitle.text = titleDateFormat.format(calendar.time)

        dates.clear()

        val monthCalendar = calendar.clone() as Calendar
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfMonth = monthCalendar.get(Calendar.DAY_OF_WEEK) - 1
        monthCalendar.add(Calendar.DAY_OF_MONTH, -firstDayOfMonth)

        while (dates.size < maxDays) {
            dates.add(monthCalendar.time)
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        gridAdapter = CustomCalendarGridAdapter(context, dates)
        gridView.adapter = gridAdapter
    }

    private fun configureListeners() {
        prevButton.setOnClickListener {
            calendar.add(Calendar.MONTH, -1)
            (context as NavigationBarActivity).currentCalendar = calendar
            configureCalendar()
        }

        nextButton.setOnClickListener {
            calendar.add(Calendar.MONTH, 1)
            (context as NavigationBarActivity).currentCalendar = calendar
            configureCalendar()
        }

        gridView.setOnItemClickListener { _, view, position, _ ->
            if (view.dateTextView.isVisible) {
                (context as NavigationBarActivity).selectDate(dates[position])
                configureCalendar()
            }
        }
    }
}