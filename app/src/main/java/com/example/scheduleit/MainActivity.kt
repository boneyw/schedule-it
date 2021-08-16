package com.example.scheduleit

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    val eventdata = null
    val STORAGE_LOCAL =101
    val context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        applicationContext
        val eventDatabasek = EventDatabasek(context)
        checkPer(WRITE_EXTERNAL_STORAGE, "storage", STORAGE_LOCAL)

        //eventDatabasek.writableDatabase





        val calen = findViewById<Button>(R.id.btnCal)
        val curr = findViewById<Button>(R.id.btnCurrApp)
        val newpla = findViewById<Button>(R.id.btnSetNew)
        val exitapp = findViewById<Button>(R.id.btnExit)

        calen.setOnClickListener{
            val intent = Intent(this, Cal::class.java)
            startActivity(intent)
        }
        curr.setOnClickListener {
            val intent = Intent( this, CurrentSch::class.java)
            startActivity(intent)
        }
        newpla.setOnClickListener{
            val intent = Intent(this, NewPlan::class.java)
            startActivity(intent)
        }

        exitapp.setOnClickListener {
            finish()
            exitProcess(0)
        }
    }



    private fun checkPer(permission: String, name: String, requestCode: Int){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED ->{
                    Toast.makeText(applicationContext, "$name Permission granted", Toast.LENGTH_SHORT).show()
                }
                shouldShowRequestPermissionRationale(permission)->showDialog(permission, name, requestCode)
                else -> ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
            }
        }
    }


    fun OnRequestPermissionsResultCallback(requestCode: Int, permission: Array<out String>, grantResult: IntArray){
        fun innerCheck(name: String){
            if (grantResult.isEmpty()|| grantResult[0]!= PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext, "$name permission refused", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext, "$name permission granted", Toast.LENGTH_SHORT).show()
            }
        }
        when(requestCode){
            STORAGE_LOCAL -> innerCheck("storage")
        }
    }

    private fun showDialog(permission: String, name: String, requestCode: Int){
        val builder = AlertDialog.Builder(this)

        builder.apply{
            setMessage("Permission to assess your $name is required to use this app")
            setTitle("permission required")
            setPositiveButton("Ok"){ dialog, which ->
                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission),requestCode)
            }
        }
        val dialog = builder.create()
        dialog.show()
    }
}