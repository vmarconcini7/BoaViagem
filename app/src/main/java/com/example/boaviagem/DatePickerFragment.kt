package com.example.boaviagem

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.widget.DatePicker
import java.util.*

class DatePickerFragment : androidx.fragment.app.DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, year, month, day)

        return super.onCreateDialog(savedInstanceState)
    }

/*    fun onCreateDialog(savedInstanceState: Bundle): Dialog {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, this, year, month, day)
    }*/

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        // Do something with the date chosen by the user
    }
}