package com.lixiong.googletraining.activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lixiong.googletraining.R;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class IntentActivity extends AppCompatActivity {

    private static final int PICK_CONTACT_REQUEST  = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Uri data = getIntent().getData();
        if(null != data){
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(R.string.intent_browser);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.intent_display);
            viewGroup.addView(textView);
            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(PICK_CONTACT_REQUEST == requestCode){
            if(RESULT_OK == resultCode){
                Uri contacts = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};

                Cursor cursor = getContentResolver().query(contacts, projection, null, null,null);
                if (null == cursor){
                    return;
                }
                List<String> contactList = new ArrayList<>();
                while (cursor.moveToNext()){
                    contactList.add(cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    contactList.add(cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                }

                ListView listView = (ListView)findViewById(R.id.contact_list);
                listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, contactList));
                cursor.close();
            }
        }
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

    public void intentContact(View view){
        Intent contactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        contactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);// Show user only contacts w/ phone numbers
        if(null != contactIntent.resolveActivity(getPackageManager())) {
            startActivityForResult(contactIntent, PICK_CONTACT_REQUEST);
        }
    }

    public void intentCamera(View view){
        Intent intent = new Intent(android.Manifest.permission.CAMERA);
        startActivityWithCheck(intent);
    }

    private void startActivityWithCheck(Intent intent){
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
