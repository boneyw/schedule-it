package com.example.scheduleit
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.newplan.*

class NewPlan: AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    var month = 0
    var day = 0
    var year = 0
    var hours = 0
    var min = 0
    var how = 0

    var savedMonth = 0
    var savedDay = 0
    var savedYear = 0
    var savedHours = 0
    var savedMin = 0
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.US)

    var valnum: Int = 0


    val eventDatabasek = EventDatabasek(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newplan)

        pickDate()
        pickTime()
        btnSchedule.setOnClickListener{
            addEvent()

        }
    }

    private fun addEvent(){

        val currdate = tv_Date.text.toString()
        val currtime = tv_Time.text.toString()
        val eEmail = em_email.text.toString()
        val currnotes = tx_notes.text.toString()
        valnum = if (sw_repeat.isChecked){
            1
        }else{
            0
        }

        if(currdate.isNotEmpty() && currtime.isNotEmpty() && eEmail.isNotEmpty() && currnotes.isNotEmpty()) {

            val status = eventDatabasek.addEvent(EventModelk(0, currdate, currtime, valnum, eEmail, currnotes))

            if (status > - 1){

                Toast.makeText(applicationContext, "EventAdd", Toast.LENGTH_LONG).show()
                em_email.text.clear()
                tx_notes.text.clear()
                tv_Date.text = "The Date"
                tv_Time.text= "The Time"
                //sw_repeat.isChecked = false
            }
        }else{
            Toast.makeText(applicationContext,"Information is missing", Toast.LENGTH_LONG).show()
        }
//        btnSchedule.setOnClickListener{
//            try {
//                val myEvent = EventModelk (1,
//                    currdate,
//                    currtime,
//                    valnum,
//                    eEmail,
//                    currnotes
//                )
//
//                Toast.makeText( this, "Event Saved", Toast.LENGTH_SHORT).show()
//            }catch (e: Exception){
//                Toast.makeText( this, "Error", Toast.LENGTH_SHORT).show()
//
//            }
//
//        }
    }
    //Gathering data for the data and time picker
    private fun getDateTimeCalendar(){
        val cal : Calendar = Calendar.getInstance()

        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hours = cal.get(Calendar.HOUR)
        min = cal.get(Calendar.MINUTE)
    }
     fun pickDate() {

        btnDate.setOnClickListener {

            getDateTimeCalendar()
            DatePickerDialog(this, this, year, month, day).show()
        }
    }
    //btnSchedule use to allow you to see the data and time picker
    fun pickTime(){

        BtnTime.setOnClickListener {

            getDateTimeCalendar()
            TimePickerDialog(this, this, hours, min, false).show()
        }
    }


    //Show the date in the right text field
    @SuppressLint("SetTextI18n")
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()

        tv_Date.text = "$savedMonth-$savedDay-$savedYear"

    }
    //Show the  in time the right text field
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int,) {

        savedHours = hourOfDay
        savedMin = minute
        getDateTimeCalendar()
        val selectedDate = Calendar.getInstance()

        tv_Time.text = timeFormat.format(selectedDate.time)
    }


}