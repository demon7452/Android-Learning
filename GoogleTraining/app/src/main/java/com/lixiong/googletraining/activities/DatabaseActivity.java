package com.lixiong.googletraining.activities;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.lixiong.googletraining.R;
import com.lixiong.googletraining.database.common.UserContract;
import com.lixiong.googletraining.database.common.UserSQLHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    private SQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        dbHelper = new UserSQLHelper(getBaseContext());
        queryData();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    public void saveData(View view){
        String name = ((EditText) findViewById(R.id.db_name)).getText().toString();
        String age = ((EditText) findViewById(R.id.db_age)).getText().toString();
        String phone = ((EditText) findViewById(R.id.db_phone)).getText().toString();
        String nativeLanguage = ((EditText) findViewById(R.id.db_native_language)).getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.NAME, name);
        values.put(UserContract.UserEntry.AGE, age);
        values.put(UserContract.UserEntry.PHONE, phone);
        values.put(UserContract.UserEntry.NATIVE_LANGUAGE, nativeLanguage);

        database.insert(UserContract.UserEntry.TABLE_NAME, null, values);

        queryData();
    }

    public void clearData(View view){

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        database.delete(UserContract.UserEntry.TABLE_NAME, null, null);

        queryData();
    }

    private void queryData(){
       ListView listView = (ListView)findViewById(R.id.db_list);

        SQLiteDatabase readDatabase = dbHelper.getReadableDatabase();

        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.NAME,
                UserContract.UserEntry.AGE,
                UserContract.UserEntry.PHONE,
                UserContract.UserEntry.NATIVE_LANGUAGE
        };

        Cursor cursor = readDatabase.query(
                UserContract.UserEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List<String> textList = new ArrayList<>();

        while (cursor.moveToNext()){
            String text =
            UserContract.UserEntry._ID + ":" + cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry._ID))
            + UserContract.UserEntry.NAME + ":" +cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.NAME))
            + UserContract.UserEntry.AGE + ":" +cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.AGE))
            + UserContract.UserEntry.PHONE + ":" +cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.PHONE))
            + UserContract.UserEntry.NATIVE_LANGUAGE + ":" +cursor.getString(cursor.getColumnIndexOrThrow(UserContract.UserEntry.NATIVE_LANGUAGE));

            textList.add(text);

        }

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, textList));
        cursor.close();
    }
}
