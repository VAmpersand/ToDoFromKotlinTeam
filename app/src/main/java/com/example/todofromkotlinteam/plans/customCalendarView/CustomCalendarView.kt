package com.example.todofromkotlinteam.plans.customCalendarView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.calendar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CustomCalendarView: LinearLayout {
    private val maxDays = 42
    private val calendar = Calendar.getInstance(Locale.ENGLISH)
    private var dates: ArrayList<Date> = ArrayList()
    private var parrentContext: Context? = null
    private val titleDateFormat = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)

    private lateinit var gridAdapter: CustomCalendarGridAdapter

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        parrentContext = context

        initializeLayout()
        configureCalendar()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    private fun initializeLayout() {
        val inflater = parrentContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.calendar_layout, this)
    }

    fun configureCalendar() {
        currentDateTitle.text = titleDateFormat.format(calendar.time)

        dates.clear()
        val monthCalendar = calendar.clone() as Calendar
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfMonth = monthCalendar.get(Calendar.DAY_OF_WEEK) - 1
        monthCalendar.add(Calendar.DAY_OF_MONTH, -firstDayOfMonth)

        while (dates.size< maxDays) {
            dates.add(monthCalendar.time)
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        prevButton.setOnClickListener {
            calendar.add(Calendar.MONTH, -1)
            configureCalendar()
        }

        nextButton.setOnClickListener {
            calendar.add(Calendar.MONTH, 1)
            configureCalendar()
        }

        gridAdapter = CustomCalendarGridAdapter(parrentContext!!, dates, calendar)
        gridView.adapter = gridAdapter

        gridView.setOnItemClickListener { adapterView, view, position, l ->
            Toast.makeText(parrentContext, position.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}