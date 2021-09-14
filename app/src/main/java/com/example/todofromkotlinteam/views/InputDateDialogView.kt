package com.example.todofromkotlinteam.views

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View

import android.widget.LinearLayout
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.type_project_dialog_layout.view.*


class InputDateDialogView: LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initializeLayout()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    private fun initializeLayout() {
        val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.type_project_dialog_layout, this)
    }

}

