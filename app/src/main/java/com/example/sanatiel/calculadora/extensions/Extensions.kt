package com.example.sanatiel.calculadora.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View
import android.widget.Toast

/**
 * Created by Sanatiel on 31/03/2018.
 */
fun Activity.toast(message: CharSequence, duration : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()
}

fun Activity.onClick(@IdRes viewId: Int, onClick:(v:android.view.View?) -> Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}