package com.meli.searcher.util

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ErrorMessages: AppCompatActivity() {

    fun msgErrorSnack(view: View, message : String){
        val snackbar = Snackbar.make(view, message, 4000)
        val snackbarLayout: View = snackbar.view

        val linearView = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        linearView.setMargins(10, 300, 10, 0)

        snackbarLayout.layoutParams = linearView
        snackbar.show()
    }

    fun toastMessage(message: String) {
        val toast =
            Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }
}