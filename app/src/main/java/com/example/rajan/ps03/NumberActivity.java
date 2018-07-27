package com.example.rajan.ps03;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NumberActivity extends AppCompatActivity {
    EditText ed;
    Button add,view,contacts,btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        add =(Button)findViewById(R.id.add);
        view =(Button)findViewById(R.id.view);
        ed =(EditText)findViewById(R.id.nos);
        contacts=(Button)findViewById(R.id.contacts);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number  = ed.getText().toString();
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(NumberActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("key",number);
                editor.apply();
                if (ed.getText().toString().trim().length() <= 0) {
                    Toast.makeText(NumberActivity.this, "Add number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(NumberActivity.this, "saved", Toast.LENGTH_SHORT).show();

                }




            }
        });
        btn =findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(NumberActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(NumberActivity.this);
                String phone = preferences.getString("key", "null");
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, phone, duration);
                toast.show();


            }
        });
        contacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult(contactPickerIntent, 1);
            }
        });



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // check whether the result is ok
        if (resultCode == RESULT_OK) {
            // Check for the request code, we might be usign multiple startActivityForReslut
            switch (requestCode) {
                case 1:
                    contactPicked(data);
                    break;
            }
        } else {
            Log.e("MainActivity", "Failed to pick contact");
        }
    }
    private void contactPicked(Intent data) {
        Cursor cursor = null;
        try {
            String phoneNo = null;// getData() method will have the Content Uri of the selected contact
            Uri uri = data.getData();
            //Query the content uri
            cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            // column index of the phone number
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            // column index of the contact name
            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            phoneNo = cursor.getString(phoneIndex);
            // Set the value to the textviews
            ed.setText(phoneNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
