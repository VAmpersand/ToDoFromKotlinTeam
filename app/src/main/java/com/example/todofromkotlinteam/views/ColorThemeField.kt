package com.example.todofromkotlinteam.views

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
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

    fun configureField(type: ColorThemeType , title: String? = null) {
        nameTheme?.setText(title)

        when (type) {
            ColorThemeType.HEALTH -> {
                nameTheme?.hint = "Health"
                inputField?.isCursorVisible = false

            }
            ColorThemeType.STUDY -> {
                nameTheme?.hint = "Study"
                inputField?.isCursorVisible = false

            }
            ColorThemeType.HOBBY -> {
                nameTheme?.hint = "Hobby"
                inputField?.isCursorVisible = false

            }
            ColorThemeType.WORK -> {
                nameTheme?.hint = "Work"
                inputField?.isCursorVisible = false

            }
            ColorThemeType.SPORT -> {
                nameTheme?.hint = "Sport"
                inputField?.isCursorVisible = false

            }
            ColorThemeType.MEETING -> {
                nameTheme?.hint = "Meeting"
                inputField?.isCursorVisible = false

            }


        }
    }
}