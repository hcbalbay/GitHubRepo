package com.example.halukcan.bitirmetezi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "dokunma.db";
    public static final String TABLE_NAME = "dokunmatablo";
    public static final String COL_1 = "Dokunma";
    public static final String COL_2 = "X";
    public static final String COL_3 = "Y";



    public SQLite (Context c){
        super(c, DATABASE_NAME, null, 1);
    }

    public void onCreate (SQLiteDatabase db){
        String sql ="create table dokunmatablo (id integer primary key autoincrement, dokunma text not null)";
        db.execSQL(sql);
    }
    public void onUpgrade (SQLiteDatabase db, int eski , int yeni){
        db.execSQL("drop table dokunmatablo");
    }
}
