package com.example.todofromkotlinteam.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.model.ListEvent
import kotlinx.android.synthetic.main.update_and_delete_layout.*

interface OnUpdateAndDeleteButtonClickListener{
    fun onDeleteClickListener()
    fun onUpdateClickListener()
}
class UpdateDeleteDialogView(listener: OnUpdateAndDeleteButtonClickListener) : DialogFragment() {

    var listener = listener
    private var currentEvent : ListEvent? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.update_and_delete_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        configureUpdateDelete()
    }


    private fun configureUpdateDelete() {
        onUpdate.setOnClickListener {
            listener.onUpdateClickListener()
            dialog?.hide()
        }

        onDelete.setOnClickListener {
            listener.onDeleteClickListener()
            dialog?.hide()
        }
    }

}