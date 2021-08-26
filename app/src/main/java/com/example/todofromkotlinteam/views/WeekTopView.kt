package com.example.todofromkotlinteam.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.calendar_layout.*
import kotlinx.android.synthetic.main.calendar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class WeekTopView: LinearLayout {
    private val maxDays = 7
//    private var calendar = Calendar.getInstance(Locale.ENGLISH)
    private var dates: ArrayList<Date> = ArrayList()
    private val titleDateFormat = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)
    private lateinit var gridAdapter: WeekTopGridAdapter

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        initializeLayout()
        configureWeek(context)
        configureListeners()
    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.week_top_view_layout, this)
    }

    fun configureWeek(context: Context) {
        val calendar = (context as NavigationBarActivity).calendar
        currentDateTitle.text = titleDateFormat.format(calendar.time)

        dates.clear()
        val weekCalendar = calendar.clone() as Calendar
        weekCalendar.set(Calendar.DAY_OF_WEEK, 1)
        val firstDayOfWeek = weekCalendar.get(Calendar.DAY_OF_WEEK) - 1
        weekCalendar.add(Calendar.DAY_OF_MONTH, -firstDayOfWeek)

        while (dates.size < maxDays) {
            dates.add(weekCalendar.time)
            weekCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        gridAdapter = WeekTopGridAdapter(context, dates, calendar)
        gridView.adapter = gridAdapter
    }

    private fun configureListeners() {
        gridView.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}