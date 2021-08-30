package com.example.todofromkotlinteam.plans.customCalendarView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.todofromkotlinteam.R
import java.util.*

class CustomCalendarGridAdapter: ArrayAdapter<Date> {
    private var parentContext: Context
    private var dates: List<Date>
    private var inflater: LayoutInflater
    private var currentCalendar : Calendar

    constructor(context: Context, dates: List<Date>, currentCalendar: Calendar) : super(context, R.layout.calendar_date_layout){
        parentContext = context
        this.dates = dates
        this.currentCalendar = currentCalendar
        inflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val date = dates[position]
        val dateCalendar = Calendar.getInstance()

        val todayMonth = dateCalendar.get(Calendar.MONTH) + 1
        val todayYear = dateCalendar.get(Calendar.YEAR)

        dateCalendar.time = date

        val displayDay = dateCalendar.get(Calendar.DAY_OF_MONTH)
        val displayMonth = dateCalendar.get(Calendar.MONTH) + 1
        val displayYear = dateCalendar.get(Calendar.YEAR)

        val currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH)
        val currentMonth = currentCalendar.get(Calendar.MONTH) + 1
        val currentYear = currentCalendar.get(Calendar.YEAR)

        var view = convertView
        if(view == null) view = inflater.inflate(R.layout.calendar_date_layout, null)
        val dateTV = view?.findViewById<TextView>(R.id.dateTV)
        dateTV?.isVisible = (currentMonth == displayMonth && currentYear == displayYear)

        val backgroundView = view?.findViewById<View>(R.id.dateBackgrount)
        val backgrount = backgroundView?.background

        if(currentYear == todayYear && currentMonth == todayMonth && currentDay == displayDay){
            backgrount?.setTint(parentContext.resources.getColor(R.color.main_orange,null))
            dateTV?.setTextColor(parentContext.resources.getColor(R.color.white,null))
        }else{
            backgrount?.setTint(parentContext.resources.getColor(R.color.background,null))
            dateTV?.setTextColor(parentContext.resources.getColor(R.color.text_title,null))
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