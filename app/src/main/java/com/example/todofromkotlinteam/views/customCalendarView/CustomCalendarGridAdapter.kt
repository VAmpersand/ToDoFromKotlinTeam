package com.example.todofromkotlinteam.views.customCalendarView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import java.util.*

class CustomCalendarGridAdapter : ArrayAdapter<Date> {
    private var dates: List<Date>
    private var inflater: LayoutInflater
    private var currentCalendar = Calendar.getInstance(Locale.ENGLISH)
    private var selectedDate = Date()

    constructor(context: Context, dates: List<Date>, currentCalendar: Calendar, selectedDate: Date) : super(context, R.layout.calendar_date_layout) {
        this.dates = dates
        this.currentCalendar = currentCalendar
        this.selectedDate = selectedDate

        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var calendar = Calendar.getInstance()
        val todayDay = calendar.get(Calendar.DAY_OF_MONTH)
        val todayMonth = calendar.get(Calendar.MONTH) + 1
        val todayYear = calendar.get(Calendar.YEAR)

        calendar.time = dates[position] // Displaying date args
        val displayDay = calendar.get(Calendar.DAY_OF_MONTH)
        val displayMonth = calendar.get(Calendar.MONTH) + 1
        val displayYear = calendar.get(Calendar.YEAR)

        calendar.time = selectedDate // Selected day args
        val selectedDay = calendar.get(Calendar.DAY_OF_MONTH)
        val selectedMonth = calendar.get(Calendar.MONTH) + 1
        val selectedYear = calendar.get(Calendar.YEAR)

        calendar = currentCalendar
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val currentYear = calendar.get(Calendar.YEAR)

        var view = convertView
        if (view == null) view = inflater.inflate(R.layout.calendar_date_layout, null)

        val dateTextView = view?.findViewById<TextView>(R.id.dateTextView)
        dateTextView?.isVisible = (currentMonth == displayMonth && currentYear == displayYear)

        val backgroundView = view?.findViewById<View>(R.id.dateBackground)
        backgroundView?.isVisible = (currentMonth == displayMonth && currentYear == displayYear)

        if (displayDay == selectedDay && displayMonth == selectedMonth && displayYear == selectedYear && dateTextView?.isVisible == true) {
            backgroundView?.background?.setTint(context.resources.getColor(R.color.text_subtitle, null))
            dateTextView?.setTextColor(context.resources.getColor(R.color.white, null))

        } else {
            backgroundView?.background?.setTint(context.resources.getColor(R.color.background, null))
            dateTextView?.setTextColor(context.resources.getColor(R.color.text_title, null))
        }

        if (displayDay == todayDay && displayMonth == todayMonth && displayYear == todayYear) {
            backgroundView?.background?.setTint(context.resources.getColor(R.color.main_orange, null))
            dateTextView?.setTextColor(context.resources.getColor(R.color.white, null))
        }

        dateTextView?.text = displayDay.toString()
        return view!!
    }

    override fun getCount(): Int {
        return dates.size
    }

    override fun getPosition(item: Date?): Int {
        return dates.indexOf(item)
    }

    override fun getItem(position: Int): Date? {
        return dates[position]
    }
}