package com.lixiong.googletraining.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lixiong.googletraining.R;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    public void intentCall(View view){
        Uri phone = Uri.parse("tel:13636529597");
        startActivityWithCheck(new Intent(Intent.ACTION_DIAL, phone));
    }

    public void intentMap(View view){
// Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
// Or map point based on latitude/longitude
// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        String title = getResources().getString(R.string.intent_chooser);
        Intent chooser = Intent.createChooser(mapIntent, title);
        startActivityWithCheck(chooser);
    }

    public void intentEmail(View view){

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris

        String title = getResources().getString(R.string.intent_chooser);
        Intent chooser = Intent.createChooser(emailIntent, title);

        startActivityWithCheck(chooser);
    }

    public void intentBrowser(View view){
        Uri web = Uri.parse("http://www.baidu.com");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, web);
        String title = getResources().getString(R.string.intent_chooser);
        Intent chooser = Intent.createChooser(webIntent, title);
        startActivityWithCheck(chooser);
    }

    private void startActivityWithCheck(Intent intent){
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
