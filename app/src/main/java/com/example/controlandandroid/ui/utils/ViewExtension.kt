package com.example.controlandandroid.ui.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

fun View.setGone() {
    visibility = View.GONE
}

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun View.animateHideAction() {
    this.animate()
        .alpha(0f)
        .setDuration(200)
        .setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                this@animateHideAction.setGone()
            }
        })
}

fun View.animateShowAction() {
    alpha = 0f
    setVisible()
    animate()
        .alpha(1f)
        .setDuration(300)
        .setListener(null)
}