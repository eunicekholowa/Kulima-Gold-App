package com.example.kulimagoldapplication.Databases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {
        public static final String DBNAME = "Login.db";

        public DBHelper(Context context) {
            super(context, "Login.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase MyDB) {
            MyDB.execSQL("create Table users (Email TEXT primary key, Password TEXT, rePassword TEXT)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
            MyDB.execSQL("drop Table if exists users ");
        }
        public Boolean insertData (String Email, String Password){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("Email", Email);
            contentValues.put("Password", Password);
            contentValues.put("rePassword", Password);

            long result =MyDB.insert("users", null,  contentValues);
            if(result==-1) return false;
            else
                return true;
        }
        public Boolean checkEmail (String Email){
            SQLiteDatabase MyDB = this.getWritableDatabase();
            Cursor cursor = MyDB.rawQuery("select * from users where Email = ?", new String[] {Email});
            if (cursor.getCount()>0)
                return true;
            else
                return false;
        }
        public Boolean checkEmailPassword (String Email, String Password){
            SQLiteDatabase MMyDB = this.getReadableDatabase();
            Cursor cursor = MMyDB.rawQuery("select * from users where Email = ? and Password = ?", new String[] {Email,Password});
            if (cursor.getCount()>0)
                return true;
            else
                return false;
        }


    }
