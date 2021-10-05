package com.example.todofromkotlinteam.views

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.RoomAppDB
import com.example.todofromkotlinteam.db.model.ListEventType
import kotlinx.android.synthetic.main.color_theme_dialog.*
import kotlinx.android.synthetic.main.rgb_select_color_layout.*


interface OnHexDialogButtonClickListener {
    fun onHexOkClickListener()
  }

class HexSelectColorDialogView(listener: OnHexDialogButtonClickListener) : DialogFragment(){
    private val listener = listener
    lateinit var hexColor: String

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.rgb_select_color_layout, container, false)
    }

     override fun onStart() {
        super.onStart()
        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        updateColor()
    }

    @SuppressLint("ResourceType", "NotifyDataSetChanged")
    private fun configureListeners() {
        seekBarRed?.setOnSeekBarChangeListener(seekBarChangeListener)
        seekBarGreen?.setOnSeekBarChangeListener(seekBarChangeListener)
        seekBarBlue?.setOnSeekBarChangeListener(seekBarChangeListener)
        okHexButton?.setOnClickListener {
          if (editTextTitle.text.isEmpty()) editTextTitle.error = "Enter the title new event"
          else {
               val title = editTextTitle?.text.toString()
               val listEventTypeDao = RoomAppDB.getAppDB(requireContext())?.listEventTypeDao()
                listEventTypeDao?.insertListEventType(
                        ListEventType(
                                color = hexColor,
                                title = title  ))
                    listener.onHexOkClickListener()
              dialog?.hide()
          }
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

        viewHexColor?.background?.setTint(Color.argb(255,redValue,greenValue,blueValue))
        hexColor = String.format("#%02x%02x%02x",redValue,greenValue,blueValue)
    }
}



