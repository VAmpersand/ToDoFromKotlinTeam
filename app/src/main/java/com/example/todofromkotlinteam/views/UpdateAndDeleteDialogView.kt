package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R

class UpdateAndDeleteDialogView() : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.update_and_delete_dialog_layout, container, false)
    }


    override fun onStart() {
        super.onStart()
        configureDialogAlert()

    }

    override fun onResume() {
        super.onResume()
        configureDialogAlert()

    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

}