package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import kotlinx.android.synthetic.main.color_theme_dialog.*
import kotlinx.android.synthetic.main.type_input_dialog_layout.okButton

class InputColorDialogView : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.color_theme_dialog, container, false)

        configureFields()
    }

    override fun onStart() {
        super.onStart()
        configureListeners()
    }

    private fun configureListeners() {

        okButton?.setOnClickListener {
            dialog?.hide()
        }
    }

    private fun configureFields() {
        themeHealth?.configureField(ColorThemeType.HEALTH)
        themeStudy?.configureField(ColorThemeType.STUDY)
        themeHobby?.configureField(ColorThemeType.HOBBY)
        themeWork?.configureField(ColorThemeType.WORK)
        themeSport?.configureField(ColorThemeType.SPORT)
        themeMeeting?.configureField(ColorThemeType.MEETING)
    }
}
