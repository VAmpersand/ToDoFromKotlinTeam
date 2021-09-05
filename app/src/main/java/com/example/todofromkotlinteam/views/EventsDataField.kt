package com.example.todofromkotlinteam.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.new_event_element.view.*

class EventsDataField: LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initializeLayout()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.new_event_element, this)
    }

    public fun configureField(title: String, iconId: Int?) {
        contentEvent?.text = title
        if (iconId != null) iconEvent?.setImageResource(iconId!!)
    }
}