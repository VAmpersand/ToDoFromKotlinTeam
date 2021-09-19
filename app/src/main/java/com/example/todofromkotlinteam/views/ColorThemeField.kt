package com.example.todofromkotlinteam.views

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEvent
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.color_theme_dialog.view.*
import kotlinx.android.synthetic.main.color_theme_field_layout.view.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.*
import kotlinx.android.synthetic.main.new_event_field_layout.view.inputField

enum class ColorThemeType {
    HEALTH, STUDY, HOBBY, WORK, SPORT, MEETING
}

class ColorTemaField: LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initializeLayout()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.color_theme_field_layout, this)
    }





//    fun configureField(type: ColorThemeType , title: String? = null) {
//        nameTheme?.setText(title)
//
//        when (type) {
//            ColorThemeType.HEALTH -> {
//                nameTheme?.hint = "Health"
//                nameTheme?.isCursorVisible = false
//                nameTheme?.isFocusable = false
//                nameTheme?.inputType = InputType.TYPE_NULL
//            }
//            ColorThemeType.STUDY -> {
//                nameTheme?.hint = "Study"
//                nameTheme?.isCursorVisible = false
//                nameTheme?.isFocusable = false
//                nameTheme?.inputType = InputType.TYPE_NULL
//            }
//            ColorThemeType.HOBBY -> {
//                nameTheme?.hint = "Hobby"
//                nameTheme?.isCursorVisible = false
//                nameTheme?.isFocusable = false
//                nameTheme?.inputType = InputType.TYPE_NULL
//            }
//            ColorThemeType.WORK -> {
//                nameTheme?.hint = "Work"
//                nameTheme?.isCursorVisible = false
//                nameTheme?.isFocusable = false
//                nameTheme?.inputType = InputType.TYPE_NULL
//            }
//            ColorThemeType.SPORT -> {
//                nameTheme?.hint = "Sport"
//                nameTheme?.isCursorVisible = false
//                nameTheme?.isFocusable = false
//                nameTheme?.inputType = InputType.TYPE_NULL
//            }
//            ColorThemeType.MEETING -> {
//                nameTheme?.hint = "Meeting"
//                nameTheme?.isCursorVisible = false
//                nameTheme?.isFocusable = false
//                nameTheme?.inputType = InputType.TYPE_NULL
//            }
//
//
//        }
//    }
}