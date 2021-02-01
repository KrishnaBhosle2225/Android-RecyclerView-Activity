package com.krishna.recyclerviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {

    TextView name;
    TextView phone;
    TextView email;
    TextView website;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        name = findViewById(R.id.getName);
        phone = findViewById(R.id.getPhone);
        email = findViewById(R.id.getEmail);
        website = findViewById(R.id.getWebsite);

        Intent intent = getIntent();
        String myName = intent.getStringExtra("mName");
        String myPhone = intent.getStringExtra("mPhone");
        String myEmail = intent.getStringExtra("mEmail");
        String myWebsite = intent.getStringExtra("mWebsite");

        name.setTextColor(Color.RED);
        phone.setTextColor(Color.RED);
        email.setTextColor(Color.RED);
        website.setTextColor(Color.BLUE);
        name.setText("Name is : "+myName);
        phone.setText("Phone no is : "+myPhone);
        email.setText("Email is : "+myEmail);
        website.setText("Website is : "+myWebsite);

    }
}