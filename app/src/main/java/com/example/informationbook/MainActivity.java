package com.example.informationbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //object from RecyclerView Component.
    private RecyclerView recyclerView;
    //an array which is ModelClass datatype
   // private ArrayList<ModelClass> arrayList;
    //or
    private ArrayList<ModelClass>arrayList = new ArrayList<>();
    private AdapterClass adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*******************RecyclerView - used to scroll through a collection of items.**************
        recyclerView = findViewById(R.id.recycler);

        //**********define arrayList*********8
        //arrayList = new ArrayList<>();

        //*********Layout Manager - used to position every item and define how scrolling works*******
        //Linear Layout Manager which displays the list vertically.
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //********Grid layout Manager to create a grid.**********
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

       //******recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));*****
        //Create objects from Model class
        ModelClass model1 = new ModelClass("countries","The Countries");
        ModelClass model2 = new ModelClass("jacinda","The Leaders");
        ModelClass model3 = new ModelClass("museum","The Museum");
        ModelClass model4 = new ModelClass("wonders","Seven wonders of the world");
        //pass the objects created to array adapter class by an array which is ModelClass datatype
        arrayList.add(model1);
        arrayList.add(model2);
        arrayList.add(model3);
        arrayList.add(model4);
        adapter = new AdapterClass(arrayList,this);
        recyclerView.setAdapter(adapter);

    }
}