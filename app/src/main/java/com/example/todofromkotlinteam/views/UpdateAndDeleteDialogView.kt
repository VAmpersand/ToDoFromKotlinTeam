package com.example.todofromkotlinteam.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.todofromkotlinteam.R
import com.example.todofromkotlinteam.db.model.ListEvent
import kotlinx.android.synthetic.main.ideas_fragment.*
import kotlinx.android.synthetic.main.plans_fragment.*
import kotlinx.android.synthetic.main.update_and_delete_dialog_layout.*

interface UpdateAndDeleteEvent{
    fun deleteEvent(item: ListEvent?)
}


class UpdateAndDeleteDialogView(listener: UpdateAndDeleteEvent) : DialogFragment(){


    private var listener = listener
    private var currentEvent: ListEvent? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return inflater.inflate(R.layout.update_and_delete_dialog_layout, container, false)
    }

    override fun onStart() {
        super.onStart()

        configureDialogAlert()
        configureListeners()
    }

    override fun onResume() {
        super.onResume()

        configureDialogAlert()
        configureListeners()
    }

    private fun configureDialogAlert() {
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun configureListeners(){
            deleteButton?.setOnClickListener{

                    listener.deleteEvent(currentEvent)
                    dialog?.hide()
              }

        updateButton?.setOnClickListener{
            recycleViewPlans?.adapter?.notifyDataSetChanged()
            recycleViewIdeas?.adapter?.notifyDataSetChanged()
            dialog?.hide()
        }
    }
}