package com.krishna.recyclerviewactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText phone;
    EditText website;
    EditText email;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    name = findViewById(R.id.edtName);
    phone = findViewById(R.id.edtPhone);
    email = findViewById(R.id.edtEmail);
    website = findViewById(R.id.edtWebsite);
    add = findViewById(R.id.btnAdd);



    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this,RecyclerView_List.class);

            intent.putExtra("mName", name.getText().toString().trim());
            intent.putExtra("mPhone", phone.getText().toString().trim());
            intent.putExtra("mEmail", email.getText().toString().trim());
            intent.putExtra("mWebsite", website.getText().toString().trim());
            startActivity(intent);
            name.setText(null);
            phone.setText(null);
            email.setText(null);
            website.setText(null);
        }
    });




    }
}