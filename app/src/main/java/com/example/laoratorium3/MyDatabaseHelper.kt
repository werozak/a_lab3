package com.example.laoratorium3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.ArrayList

class MyDatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
     companion object{
         var DATABASE_NAME = "MojaBaza"
         var TABLE_NAME = "MojaTabela"
     }
    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("not implemented")
        //To change body of created functions use File | Settings | File Templates.
        p0?.execSQL("CREATE TABLE IF NOT EXISTS $TABLE_NAME (id INT PRIMARY KEY AUTOINCREMENT, kolumna1 TEXT)")
    }
    fun insert(kolumna1:String){
        var cv=ContentValues()
        cv.put("kolumna1",kolumna1)
        this.writableDatabase.insert(TABLE_NAME,null,cv)
    }
    //fun insert(dystans:String, data: String){
    //    var db = this.writableDatabase
    //   var cv = ContentValues()
     //   cv.apply {
     //       put("kolumna1", dystans)
     //   }
     //   db.insert(TABLE_NAME, null, cv)
   // }
    fun selectAll(): ArrayList<String> {
        var db = this.readableDatabase
        var cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        var dane = ArrayList<String>()



        cursor.moveToFirst()
        while (cursor.isAfterLast) {
            dane.add("${cursor.getString(0)} ${cursor.getString(1)} }")

            cursor.moveToNext()
        }
        db.close()
        return dane
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}