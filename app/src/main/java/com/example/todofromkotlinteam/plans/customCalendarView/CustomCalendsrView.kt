package com.example.todofromkotlinteam.plans.customCalendarView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.calendar_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

class CustomCalendsrView: LinearLayout {
    private var parrentContext: Context? = null
    private val calendar = Calendar.getInstance(Locale.ENGLISH)
    private val titleDateFormat = SimpleDateFormat("MMM yyyy", Locale.ENGLISH)

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