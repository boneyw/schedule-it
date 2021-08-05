package com.example.scheduleit
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class NewPlan: AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

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
    var timeFormat = SimpleDateFormat("hh:mm a", Locale.US)

    var tDate: TextView? = findViewById<TextView>(R.id.tv_Date)
    var tTime: TextView = findViewById(R.id.tv_Time)
    var tNote: EditText = findViewById(R.id.tx_notes)
    var email:  EditText = findViewById(R.id.em_email)
    var btn_schedule: Button = findViewById(R.id.btnSchedule)
    var swRepeat: CheckBox = findViewById(R.id.sw_repeat)

    private var valnum:Int =0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newplan)
        applicationContext


        if (swRepeat.isChecked == true){
            valnum = 1
        }else{
            valnum = 0
        }


        pickDate()
        pickTime()
        addEvent()

    }


    private fun addEvent(){

        val currdate = tDate?.text.toString()
        val currtime = tTime.text.toString()
        val eEmail = email.text.toString()
        val currnotes = tNote.text.toString()

        val eventDatabasek: EventDatabasek = EventDatabasek(this)
        if(!currdate.isEmpty() && !currtime.isEmpty() && !eEmail.isEmpty() && !currnotes.isEmpty()){
            val status = eventDatabasek.addEvent(EventModelk(1, currdate,currtime, valnum, eEmail, currnotes))
            if (status >-1){

                email.text.clear()
                tNote.text.clear()
                Toast.makeText(applicationContext, "EventAdd", Toast.LENGTH_LONG).show()


            }else{
                Toast.makeText(applicationContext,"Information is missing", Toast.LENGTH_LONG).show()
            }
        }
        btn_schedule.setOnClickListener{
            try {
                val myEvent = EventModel (-1, tDate?.text as String?,
                    tTime.text as String?, swRepeat.isChecked, email.text as String?,
                    tNote.text as String?)

                Toast.makeText( this, myEvent.toString(), Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                Toast.makeText( this, "Error", Toast.LENGTH_SHORT).show()

            }
        }
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
        val thedate: Button = findViewById(R.id.btnDate)

        thedate.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(this, this, year, month, day).show()
        }
    }
    //btnSchedule use to allow you to see the data and time picker
    fun pickTime(){
        val theTime: Button = findViewById(R.id.BtnTime)

        theTime.setOnClickListener {

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

        tDate?.text = "$savedMonth-$savedDay-$savedYear"

    }
    //Show the  in time the right text field
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int,) {


        savedHours = hourOfDay
        savedMin = minute
        getDateTimeCalendar()
        val selectedDate = Calendar.getInstance()

        tTime.text = timeFormat.format(selectedDate.time)
    }


}