package com.lixiong.googletraining.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lixiong.googletraining.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

import common.Constants;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String editMessage = intent.getStringExtra(Constants.EDIT_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(editMessage + "\n" + getTextFromFile());


        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_display_message);
        viewGroup.addView(textView);

    }

    private String getTextFromFile(){
        String text = "";
        File file = new File(getBaseContext().getFilesDir(), Constants.FILE_NAME);
        try{
            Scanner read = new Scanner(file);
            while (read.hasNext()){
                text = text + read.nextLine() + "\n";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }
}
