package com.senai.lugaluga.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LugaLugaDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLES =
            "CREATE TABLE USUARIO (" +
                    " NOME TEXT(52)," +
                    " EMAIL TEXT(32));";

    private static final String SQL_DELETE_POSTS =
            "DROP TABLE IF EXISTS USUARIO ";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "LugaLuga.db";

    public LugaLugaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_POSTS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
