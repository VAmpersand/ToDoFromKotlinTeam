package com.example.todofromkotlinteam.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R

enum class EventType{
    PLANS, IDEAS
}

class InputTypeProjectView: LinearLayout {
    var currentType = EventType.PLANS

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initializeLayout()
    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.type_project_dialog_layout, this)
    }

    fun select(type: EventType) {
        when (type) {
            EventType.PLANS -> {
               
            }
            EventType.IDEAS -> {

            }
        }
    }

}