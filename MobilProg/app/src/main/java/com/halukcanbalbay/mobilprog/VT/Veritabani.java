package com.halukcanbalbay.mobilprog.VT;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Veritabani extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "todo.db";

    private static final int VERSION = 1;

    public Veritabani(Context context) {
        super(context, DATABASE_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        final String CREATE_TABLE = "CREATE TABLE " + VTBaglanti.TaskEntry.TABLE_NAME + " (" +
                VTBaglanti.TaskEntry._ID                       +    " INTEGER PRIMARY KEY, "+
                VTBaglanti.TaskEntry.COLUMN_DESCRIPTION        +    " TEXT NOT NULL, " +
                VTBaglanti.TaskEntry.COLUMN_PRIORITY           +    " INTEGER NOT NULL, " +
                VTBaglanti.TaskEntry.COLUMN_DATE               +    " TEXT NOT NULL, " +
                VTBaglanti.TaskEntry.COLUMN_TIME               +     "TEXT NOT NULL " + " );";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + VTBaglanti.TaskEntry.TABLE_NAME);
        onCreate(db);

    }
}
