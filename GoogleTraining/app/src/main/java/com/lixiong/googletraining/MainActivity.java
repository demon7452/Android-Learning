package com.lixiong.googletraining;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.lixiong.googletraining.activities.DatabaseActivity;
import com.lixiong.googletraining.activities.DisplayMessageActivity;
import com.lixiong.googletraining.activities.FragmentActivity;

import java.io.FileOutputStream;

import common.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String editMessage = editText.getText().toString();

        saveFile(editMessage);

        intent.putExtra(Constants.EDIT_MESSAGE, editMessage);
        startActivity(intent);
    }

    public void openFragment(View view){
        startActivity(new Intent(this, FragmentActivity.class));
    }

    public void openDatabase(View view){
        startActivity(new Intent(this, DatabaseActivity.class));
    }

    private void saveFile(String text){
        FileOutputStream outputStream;
        try{
            outputStream = openFileOutput(Constants.FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.write(Constants.EDIT_MESSAGE.getBytes());
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
