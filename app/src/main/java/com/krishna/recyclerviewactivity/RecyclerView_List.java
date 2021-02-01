package com.krishna.recyclerviewactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_List extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserDetails> userList;
    UserDetails userDetails;
    Button add;
    AdapterUser adapterUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view__list);

        add = findViewById(R.id.addUser);
        recyclerView = findViewById(R.id.recycler_View);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userList = new ArrayList<>();
        adapterUser = new AdapterUser(this, userList);

        recyclerView.setAdapter(adapterUser);





        add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = getIntent();
            String Name = intent.getStringExtra("mName");
            String Phone = intent.getStringExtra("mPhone");
            String Email = intent.getStringExtra("mEmail");
            String Website = intent.getStringExtra("mWebsite");

            userDetails = new UserDetails();
            userDetails.setName(Name);
            userDetails.setPhone(Phone);
            userDetails.setEmail(Email);
            userDetails.setWebsite(Website);

            userList.add(userDetails);
            adapterUser.notifyDataSetChanged();


        }
    });
    }
}
