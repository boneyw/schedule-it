package com.example.scheduleit

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class EventDatabasek(context: Context) :

    SQLiteOpenHelper(context, DATABASE_NAME,  null, DATABASE_VERSION){


    companion object {
        private const val DATABASE_VERSION =1
        private const val DATABASE_NAME ="EventDataBase"
        private const val TABLE_CONTACTS = "EventTable"

        private const val KEY_ID = "_id"
        private const val KEY_DATE = "date"
        private const val KEY_TIME = "time"
        private const val KEY_REPEAT = "repeat"
        private const val KEY_EMAIL = "email"
        private const val KEY_NOTES = "notes"
    }
    override fun onCreate(db: SQLiteDatabase?){

        val CREATE_CONTACTS_TABLE = (" CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DATE + " TEXT NOT NULL," + KEY_TIME + " TEXT NOT NULL,"
                + KEY_REPEAT + " INTEGER NOT NULL," + KEY_EMAIL + " TEXT NOT NULL," + KEY_NOTES + " TEXT NOT NULL" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")

        onCreate(db)
    }

    fun addEvent(evt: EventModelk): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()

        //contentValues.put(KEY_ID, evt.id)
        contentValues.put(KEY_DATE, evt.dDate)
        contentValues.put(KEY_TIME, evt.tTime)
        contentValues.put(KEY_REPEAT, evt.repeat)
        contentValues.put(KEY_EMAIL, evt.eEmail)
        contentValues.put(KEY_NOTES, evt.nNotes)

        val success = db.insert(TABLE_CONTACTS, null, contentValues)
        db.close()

        return success
    }

    @SuppressLint("Recycle")
    fun veiwEvent (): ArrayList<EventModelk> {
        val evtlist: ArrayList<EventModelk> = ArrayList()
        val  selectQueue = "SELECT * FROM $TABLE_CONTACTS"

        val db = this.readableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQueue, null)

        }catch (e: SQLiteException){

            db.execSQL(selectQueue)

            return  ArrayList()
        }
        var id:Int
        var date: String
        var time: String
        var repeat: Int
        var email: String
        var note: String

        if (cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                date = cursor.getString(cursor.getColumnIndex(KEY_DATE))
                time = cursor.getString(cursor.getColumnIndex(KEY_TIME))
                repeat = cursor.getInt(cursor.getColumnIndex(KEY_REPEAT))
                email = cursor.getString(cursor.getColumnIndex(KEY_EMAIL))
                note = cursor.getString(cursor.getColumnIndex(KEY_NOTES))

                val evt = EventModelk(id = id, dDate = date, tTime = time, repeat = repeat, eEmail = email, nNotes = note)
                evtlist.add(evt)
            }while (cursor.moveToNext())

        }
        return evtlist
    }

    fun updateEventdata(evt: EventModelk): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(KEY_DATE, evt.dDate)
        contentValues.put(KEY_TIME, evt.tTime)
        contentValues.put(KEY_REPEAT, evt.repeat)
        contentValues.put(KEY_EMAIL, evt.eEmail)
        contentValues.put(KEY_NOTES, evt.nNotes)

        val success = db.update(TABLE_CONTACTS, contentValues, KEY_ID + "=" + evt.id, null)


        db.close()

        return success
    }

    fun deleteEvent(evt: EventModelk): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(KEY_ID, evt.id)

        val success = db.delete(TABLE_CONTACTS, KEY_ID + "=" +evt.id, null)

        db.close()

        return success
    }
}
