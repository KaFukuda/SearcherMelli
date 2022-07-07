package com.meli.searcher.util

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ErrorMessages: AppCompatActivity() {

    fun messageErrorOnSnack(view: View, message: String){
        val snack = Snackbar.make(view, message, 3500)
        val snackLayout: View = snack.view

        val linearView = LinearLayout.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT
        )
        with(linearView) {
            setMargins(10, 300, 10, 0)
        }

        snackLayout.layoutParams = linearView
        snack.show()
    }

    fun toastMessage(message: String) {
        val toast =
            Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }
}