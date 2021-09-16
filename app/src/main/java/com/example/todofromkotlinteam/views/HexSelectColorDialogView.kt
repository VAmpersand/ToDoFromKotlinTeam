package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.type_input_dialog_layout.*
import java.util.*

interface OnHexDialogButtonClickListener{
    fun onHexOkClickListener()
}

class HexSelectColorDialogView(listener: OnHexDialogButtonClickListener) : DialogFragment() {

    private val listener = listener
    private var redSeekBar: SeekBar? = null
    private var greenSeekBar: SeekBar? = null
    private var blueSeekBar: SeekBar? = null
    private var hexView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.rgb_select_color_layout, container, false)



         }

    override fun onStart() {
        super.onStart()
        redSeekBar = view?.findViewById(R.id.seekBarRed)
        greenSeekBar = view?.findViewById(R.id.seekBarGreen)
        blueSeekBar = view?.findViewById(R.id.seekBarBlue)
        hexView = view?.findViewById(R.id.viewHexColor)
        configureDialogAlert()
        updateColor()
        redSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)
        greenSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)
        blueSeekBar?.setOnSeekBarChangeListener(seekBarChangeListener)
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

    private fun configureListeners(){
        okButton?.setOnClickListener {

             dialog?.hide()
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
        val redValue: Int = redSeekBar!!.progress
        val greenValue: Int = greenSeekBar!!.progress
        val blueValue: Int = blueSeekBar!!.progress

        hexView!!.setBackgroundColor(-0x1000000 + redValue * 0x10000 + greenValue * 0x100 + blueValue)
    }


}



