package com.lixiong.googletraining.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lixiong.googletraining.R;

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
        textView.setText(editMessage);

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_display_message);
        viewGroup.addView(textView);

    }
}
