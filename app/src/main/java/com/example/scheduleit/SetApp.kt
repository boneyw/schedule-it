package com.example.scheduleit

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import java.util.*


class SetApp : DialogFragment(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    var month = 0
    var day = 0
    var year = 0
    var hours = 0
    var min = 0

    var savedMonth = 0
    var savedDay = 0
    var savedYear = 0
    var savedHours = 0
    var savedMin = 0

     fun getDateTimeCalendar(){
        val cal :Calendar = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hours = cal.get(Calendar.HOUR)
        min = cal.get(Calendar.MINUTE)
    }

    fun pickDate() {
        getDateTimeCalendar()
        DatePickerDialog(this, this, year, month, day).show()
    }

     fun DatePickerDialog(setApp: SetApp, setApp1: SetApp, year: Int, month: Int, day: Int) {

    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        TODO("Not yet implemented")
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this, this, hours, min, true)
    }

    private fun TimePickerDialog(unit: SetApp, unit1: SetApp, hours: Int, min: Int, unit2: Boolean) {

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        TODO("Not yet implemented")
        savedHours = hourOfDay
        savedMin = minute
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDataPicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in Toast

        } as SetApp, year, month, day)
        dpd.show()
    }
}

private fun Unit.show() {
    TODO("Not yet implemented")
}
