package com.example.anton.addressbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.anton.addressbook.R;
import com.example.anton.addressbook.adapter.ContactAdapter;

/**
 * Created by anton on 09/03/2017.
 */

public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //instanziazione
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this);
        adapter = new ContactAdapter();

        //setting
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
}
