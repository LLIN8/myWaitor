package com.example.liangminglin.mywaitor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by liangminglin on 11/3/17.
 */

public class DBControll extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    SQLiteDatabase db;
    private static final String DATABASE_NAME = "RegisterInfo.db";
    private static final String TABLE_NAME = "Info";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_UNAME = "uName";
    private static final String COLUMN_PASSWORD = "pass";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_AGE = "age";

    private static final String TABLE_CREATE = "create table Info (id integer primary key not null , " +
            "uName text not null, pass text not null, email text not null, age text not null)";

    public DBControll(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertPerson(RegisterInfo person) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from Info";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_AGE, person.getAge());
        values.put(COLUMN_EMAIL, person.getEmail());
        values.put(COLUMN_PASSWORD, person.getpNum());
        values.put(COLUMN_UNAME, person.getuName());

        db.insert(TABLE_NAME,null, values);
    }

    public String searchPass(String userID){

        db = this.getReadableDatabase();
        String query = "select uName, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";



        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                if(a.equals(userID));
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

}
