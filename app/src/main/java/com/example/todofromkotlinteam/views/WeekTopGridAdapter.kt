package com.example.todofromkotlinteam.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.todofromkotlinteam.NavigationBarActivity
import com.example.todofromkotlinteam.R
import java.util.*

class WeekTopGridAdapter : ArrayAdapter<Date> {
    private var dates: List<Date>
    private var inflater: LayoutInflater

    constructor(context: Context, dates: List<Date>) : super(context, R.layout.calendar_date_layout) {
        this.dates = dates

        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var calendar = Calendar.getInstance()
        val todayDate = calendar.get(Calendar.DAY_OF_MONTH)
        val todayMonth = calendar.get(Calendar.MONTH) + 1
        val todayYear = calendar.get(Calendar.YEAR)

        calendar.time = dates[position]
        val displayDay = calendar.get(Calendar.DAY_OF_MONTH)
        val displayMonth = calendar.get(Calendar.MONTH) + 1
        val displayYear = calendar.get(Calendar.YEAR)

        calendar.time = (context as NavigationBarActivity).selectedDate
        val selecteDay = calendar.get(Calendar.DAY_OF_MONTH)
        val selecteMonth = calendar.get(Calendar.MONTH) + 1
        val selecteYear = calendar.get(Calendar.YEAR)

        calendar = (context as NavigationBarActivity).currentCalendar
        val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val currentYear = calendar.get(Calendar.YEAR)

        var view = convertView
        if (view == null) view = inflater.inflate(R.layout.calendar_date_layout, null)

        val dateTV = view?.findViewById<TextView>(R.id.dateTextView)

        val backgroundView = view?.findViewById<View>(R.id.dateBackground)
        val background = backgroundView?.background

        if (displayDay == selecteDay && displayMonth == selecteMonth && displayYear == selecteYear) {
            background?.setTint(context.resources.getColor(R.color.text_subtitle, null))
            dateTV?.setTextColor(context.resources.getColor(R.color.white, null))

        } else {
            background?.setTint(context.resources.getColor(R.color.background, null))
            dateTV?.setTextColor(context.resources.getColor(R.color.text_title, null))
        }

        if (displayDay == todayDate && displayMonth == todayMonth && displayYear == todayYear) {
            background?.setTint(context.resources.getColor(R.color.main_orange, null))
            dateTV?.setTextColor(context.resources.getColor(R.color.white, null))
        }

        dateTV?.text = displayDay.toString()

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