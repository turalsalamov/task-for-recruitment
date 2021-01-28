package com.salamov.testproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.salamov.testproject.adapters.InboxAdapter;
import com.salamov.testproject.models.Messages;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Inbox extends AppCompatActivity {

    private RecyclerView messagesRecycler;
    private Toolbar toolbar;
    private boolean isActive;
    private int profile;
    private ArrayList<Messages> messages = new ArrayList<>();
    private TextView name;
    private TextView activeOrNot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        toolbar = findViewById(R.id.toolbar_inbox);
        messagesRecycler = findViewById(R.id.messages);
        name = findViewById(R.id.sender_name);
        activeOrNot = findViewById(R.id.is_active_now);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Messages>>(){}.getType();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Log.d("PROFILE", String.valueOf(profile));
        isActive = bundle.getBoolean("active");
        messages = gson.fromJson((String) bundle.get("messages"), type);
        Log.d("Messages", String.valueOf(bundle.getBoolean("active")));

        name.setText((String)bundle.get("senderName"));
        if (isActive){
            activeOrNot.setText("online");
        }else{
            activeOrNot.setText("offline");
        }

        InboxAdapter inboxAdapter = new InboxAdapter(Inbox.this, messages, (int)bundle.get("senderProfile"), (int)bundle.get("hostProfile"), isActive);
        messagesRecycler.setAdapter(inboxAdapter);
        messagesRecycler.setLayoutManager(new LinearLayoutManager(this));
        messagesRecycler.setHasFixedSize(true);


        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}