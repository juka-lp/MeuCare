package com.example.meucare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Care> careList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        careList = new ArrayList<>();


        //adding some items to our list
        careList.add(
                new Care(
                        1,
                        "Vagner Lopes Junior",
                        "TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESTEEEEEEEEEEEEEE",
                        R.drawable.junior));

        careList.add(
                new Care(
                        1,
                        "Julia Emile Hirata",
                        "TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESTEEEEEEEEEEEEEE",
                        R.drawable.julia));

        careList.add(
                new Care(
                        1,
                        "Luan Trindade",
                        "TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESTEEEEEEEEEEEEEE",
                        R.drawable.luan));

        //creating recyclerview adapter
        CareAdapter adapter = new CareAdapter(this, careList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }





}