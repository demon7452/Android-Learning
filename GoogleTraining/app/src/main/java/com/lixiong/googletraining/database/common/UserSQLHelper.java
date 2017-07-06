package com.lixiong.googletraining.database.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nali on 03/07/2017.
 */

public class UserSQLHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "User.db";
    private static final int VERSION = 1;

    private static final String CREATE_TABLE =
            "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " (" +
            UserContract.UserEntry._ID + " INTEGER PRIMARY KEY," +
            UserContract.UserEntry.NAME + " TEXT," +
            UserContract.UserEntry.AGE + " INTEGER," +
            UserContract.UserEntry.PHONE + " TEXT," +
            UserContract.UserEntry.NATIVE_LANGUAGE + " TEXT)";

    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME;

    public UserSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
