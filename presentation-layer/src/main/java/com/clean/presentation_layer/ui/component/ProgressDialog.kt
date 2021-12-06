package com.clean.presentation_layer.ui.component

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.clean.presentation_layer.R
import dagger.hilt.android.qualifiers.ApplicationContext

class ProgressDialog(@ApplicationContext context: Context) : AlertDialog(context) {
    override fun show() {
        super.show()
        setContentView(R.layout.dialog_progress)
    }

    init {
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}