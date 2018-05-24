package com.example.halukcan.bitirmetezi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class veriKaynagi {
    SQLiteDatabase db;
    SQLite bdb;
    public veriKaynagi (Context c) {
        bdb = new SQLite(c);
    }
    public void ac() {
        db = bdb.getWritableDatabase();
    }
    public void kapat (){
        bdb.close();
    }
    public void dokunmaOlustur (dokunma d) {
        ContentValues val = new ContentValues();
        val.put("dokunma","Dokunma");
        val.put("X",d.X);
        val.put("Y",d.Y);

    }
    public void dokunmaSil (dokunma d) {
        int id = d.getId();
        db.delete("dokunmaTablo","id= ?",null );
    }
}
