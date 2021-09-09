package com.example.todofromkotlinteam.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

import com.example.todofromkotlinteam.R


class InputDateDialogView: LinearLayout {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context,attrs,defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initializeLayout()

    }

    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.date_input_dialog_layout, this)
    }





}


