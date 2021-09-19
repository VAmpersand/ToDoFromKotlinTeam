package com.example.todofromkotlinteam.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.rgb_select_color_layout.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton
import java.util.*

interface OnHexDialogButtonClickListener {
    fun onHexOkClickListener()
}

class HexSelectColorDialogView(listener: OnHexDialogButtonClickListener) : DialogFragment() {

    private val listener = listener


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.rgb_select_color_layout, container, false)
    }

     override fun onStart() {
        super.onStart()
        configureDialogAlert()
        updateColor()

        seekBarRed?.setOnSeekBarChangeListener(seekBarChangeListener)
        seekBarGreen?.setOnSeekBarChangeListener(seekBarChangeListener)
        seekBarBlue?.setOnSeekBarChangeListener(seekBarChangeListener)

        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

    private fun configureListeners() {

        okButton?.setOnClickListener {
          if (editTextTitle.text.isEmpty()){editTextTitle.setError("Enter the title new event")}
          else dialog?.hide()
        }
    }

    private val seekBarChangeListener: SeekBar.OnSeekBarChangeListener = object :
        SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            updateColor()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }

    private fun updateColor() {
        val redValue: Int = seekBarRed.progress
        val greenValue: Int = seekBarGreen.progress
        val blueValue: Int = seekBarBlue.progress

        viewHexColor?.background?.setTint(-0x1000000 + redValue * 0x10000 + greenValue * 0x100 + blueValue)
    }

}



