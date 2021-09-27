package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.model.ListEventType
import kotlinx.android.synthetic.main.color_theme_dialog.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton

interface OnColorDialogButtonClickListener {
    fun onColorOkClickListener(type: ListEventType)
    fun onAddHexClickListener()
}

class InputColorDialogView(listener: OnColorDialogButtonClickListener) : DialogFragment(), ItemSelectionListener{
    private val listener = listener
    private var currentType : ListEventType? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.color_theme_dialog, container, false)
    }

    override fun onStart() {
        super.onStart()
        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val events = ArrayList<ListEventType>()

        events.add(ListEventType(0,"#FF5252", "Здоровье"))
        events.add(ListEventType(1,"#343D8F", "Хобби"))
        events.add(ListEventType(2,"#55A738", "Работа"))
        events.add(ListEventType(3,"#FF5232", "Учеба"))
        events.add(ListEventType(4,"#FF5252", "Здоровье"))
        events.add(ListEventType(5,"#343D8F", "Хобби"))
        events.add(ListEventType(6,"#55A738", "Работа"))
        events.add(ListEventType(7,"#FF5232", "Учеба"))

        rcView?.hasFixedSize()
        rcView?.layoutManager = LinearLayoutManager(context)
        rcView?.adapter = ColorAdapter(events, requireContext(),this)
    }

    private fun configureListeners() {
        okButton?.setOnClickListener {
            if (currentType != null) {
                listener.onColorOkClickListener(currentType!!)
                dialog?.hide()
            }
        }

        newColorTheme?.setOnClickListener {
            listener.onAddHexClickListener()
            dialog?.hide()
        }
    }

    override fun select(item: ListEventType) {
        currentType = item
        rcView?.adapter?.notifyDataSetChanged()
    }
}
