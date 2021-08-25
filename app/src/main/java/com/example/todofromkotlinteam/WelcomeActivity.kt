package com.example.todofromkotlinteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.welcome_activity.*
import eightbitlab.com.blurview.RenderScriptBlur
import android.graphics.drawable.Drawable
import android.view.View

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)

        setBlurView()
    }

    private fun setBlurView() {
        val radius = 25f
        val decorView: View = window.decorView
        val windowBackground: Drawable = decorView.getBackground()

        blurView.setupWith(decorView.findViewById(android.R.id.content))
            .setFrameClearDrawable(windowBackground)
            .setBlurAlgorithm(RenderScriptBlur(this))
            .setBlurRadius(radius)
            .setBlurAutoUpdate(true)
            .setHasFixedTransformationMatrix(true)
    }

    fun onClickNext(view: View) { finish() }
}