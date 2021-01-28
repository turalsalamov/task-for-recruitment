package com.salamov.testproject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.salamov.testproject.adapters.HorizontalAdapterForMainPage;
import com.salamov.testproject.adapters.VerticalAdapterForMainPage;
import com.salamov.testproject.models.Inboxes;
import com.salamov.testproject.models.ItemsAtHorizontalAdapter;
import com.salamov.testproject.models.ItemsAtVerticalAdapter;
import com.salamov.testproject.models.Messages;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    // Deceleration of variables
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private NavigationView nav;
    private RecyclerView horizontalRecycler; // RecyclerView for people at the top
    private RecyclerView verticalRecycler; // Recycler for messages
    private ArrayList<ItemsAtHorizontalAdapter> listHorizontal = new ArrayList<>();
    private ArrayList<ItemsAtVerticalAdapter> listVertical = new ArrayList<>();
    private ArrayList<Inboxes> inboxes = new ArrayList<>();
    private ArrayList<Messages> messagesFromBird = new ArrayList<>();
    private ArrayList<Messages> messagesFromTree = new ArrayList<>();
    private ArrayList<Messages> messagesFromTiger = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing of variables
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.navigation);
        horizontalRecycler = findViewById(R.id.horizontal_recyclerview);
        verticalRecycler = findViewById(R.id.vertical_recyclerview);

        // Manually adding data

        // Setting messages
        //Messages from Bird
        messagesFromBird.add(new Messages(0, "Hellooo", 0));
        messagesFromBird.add(new Messages(1, "Hi", 0));
        messagesFromBird.add(new Messages(0, "You wanted my profile photo...", 0));
        messagesFromBird.add(new Messages(0, "I send it now", 0));
        messagesFromBird.add(new Messages(1, "I'm waiting...", 0));
        messagesFromBird.add(new Messages(0, null, R.drawable.bird));
        messagesFromBird.add(new Messages(1, "Thank you!", 0));
        inboxes.add(new Inboxes("Bird", messagesFromBird, R.drawable.bird, R.drawable.hostpp, true));

        // Messages from Tree
        messagesFromTree.add(new Messages(0, "Hellooo", 0));
        messagesFromTree.add(new Messages(1, "Hi", 0));
        messagesFromTree.add(new Messages(0, "You wanted my profile photo...", 0));
        messagesFromTree.add(new Messages(0, "I send it now", 0));
        messagesFromTree.add(new Messages(1, "I'm waiting...", 0));
        messagesFromTree.add(new Messages(0, null, R.drawable.tree));
        messagesFromTree.add(new Messages(1, "I appreciate it", 0));
        inboxes.add(new Inboxes("Tree", messagesFromTree, R.drawable.tree, R.drawable.hostpp, true));

        //Messages from Tiger
        messagesFromTiger.add(new Messages(0, "Hellooo", 0));
        messagesFromTiger.add(new Messages(1, "Hi", 0));
        messagesFromTiger.add(new Messages(0, "You wanted my profile photo...", 0));
        messagesFromTiger.add(new Messages(0, "I send it now", 0));
        messagesFromTiger.add(new Messages(1, "I'm waiting...", 0));
        messagesFromTiger.add(new Messages(0, null, R.drawable.tiger));
        messagesFromTiger.add(new Messages(1, "Good photo!", 0));
        inboxes.add(new Inboxes("Tiger", messagesFromTiger, R.drawable.tiger, R.drawable.hostpp, false));


        // For Horizontal
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.bird, "Bird"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tiger, "Tiger"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tree, "Tree"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.bird, "Bird"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tiger, "Tiger"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tree, "Tree"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.bird, "Bird"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tiger, "Tiger"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tree, "Tree"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.bird, "Bird"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tiger, "Tiger"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tree, "Tree"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.bird, "Bird"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tiger, "Tiger"));
        listHorizontal.add(new ItemsAtHorizontalAdapter(R.drawable.tree, "Tree"));

        // For Vertical
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.bird, "Bird", "Thank you!", "14:42", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tiger, "Tiger", "Good photo!", "23:32", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tree, "Tree", "I appreciate it", "05:32", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.bird, "Bird", "How are you?", "14:42", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tiger, "Tiger", "Hellooooooo", "23:32", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tree, "Tree", "My leaves are leaving me!", "05:32", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.bird, "Bird", "How are you?", "14:42", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tiger, "Tiger", "Hellooooooo", "23:32", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tree, "Tree", "My leaves are leaving me!", "05:32", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.bird, "Bird", "How are you?", "14:42", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tiger, "Tiger", "Hellooooooo", "23:32", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tree, "Tree", "My leaves are leaving me!", "05:32", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.bird, "Bird", "How are you?", "14:42", false));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tiger, "Tiger", "Hellooooooo", "23:32", true));
        listVertical.add(new ItemsAtVerticalAdapter(R.drawable.tree, "Tree", "My leaves are leaving me!", "05:32", true));

        // =================== =================== =================== =================== ===================

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Implementing NavigationView
        toolbar.setNavigationIcon(R.drawable.burger_menu);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);

        // Implementing adapters to recyclerViews
        // Horizontal recyclerview
        HorizontalAdapterForMainPage horizontalAdapterForMainPage = new HorizontalAdapterForMainPage(this, listHorizontal);
        horizontalRecycler.setHasFixedSize(true);
        horizontalRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecycler.setAdapter(horizontalAdapterForMainPage);

        // Vertical recyclerview
        VerticalAdapterForMainPage verticalAdapterForMainPage = new VerticalAdapterForMainPage(this, listVertical, new CallbackFromClickedItem() {
            @Override
            public void onClickItem(String value) {
                ArrayList<Messages> messagesArrayList = new ArrayList<>();
                int j = 0;

                for (int i = 0; i < inboxes.size(); i++){
                    if (inboxes.get(i).getWithWhom().equals(value)){
                        Log.d("TAG", "FOUND");
                        j = i;
                        messagesArrayList = new ArrayList<>(inboxes.get(i).getMessages());
                        break;
                    }
                }

                Gson gson = new Gson();
                String jsonData = gson.toJson(messagesArrayList);
                Log.d("STRING", jsonData);
                Intent intent = new Intent(MainActivity.this, Inbox.class);
                intent.putExtra("messages", jsonData);
                intent.putExtra("senderProfile", inboxes.get(j).getSenderPP());
                intent.putExtra("senderName", inboxes.get(j).getWithWhom());
                intent.putExtra("hostProfile", inboxes.get(j).getHostPP());
                intent.putExtra("active", inboxes.get(j).isActive());
                startActivity(intent);
            }
        });
        verticalRecycler.setHasFixedSize(true);
        verticalRecycler.setLayoutManager(new LinearLayoutManager(this));
        verticalRecycler.setAdapter(verticalAdapterForMainPage);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.message, menu);
        return super.onCreateOptionsMenu(menu);
    }

}