package com.example.todofromkotlinteam.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R

enum class EventTypeProject{
    PLANS, IDEAS
}

class InputTypeProjectView: LinearLayout {
    val checkBoxPlans = findViewById<CheckBox>(R.id.checkPlans)
    val checkBoxIdeas = findViewById<CheckBox>(R.id.checkIdeas)


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initializeLayout()
    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.type_project_dialog_layout, this)
    }

    fun choiceTypeProject(type: EventTypeProject) {
        when (type) {
            EventTypeProject.PLANS -> {
                checkBoxPlans.setOnCheckedChangeListener { compoundButton, b ->  }
            }
            EventTypeProject.IDEAS -> {

            }
        }
    }

}