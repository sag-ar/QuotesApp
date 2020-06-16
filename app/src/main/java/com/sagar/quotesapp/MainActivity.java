package com.sagar.quotesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    QotesAdapter qotesAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    List<QuotesModel> listquote;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.rv_quote);
        firebaseDatabase = FirebaseDatabase.getInstance();

        inirec();

    }






    private void inirec() {


        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
        databaseReference = firebaseDatabase.getReference("quotes");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listquote = new ArrayList<>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    QuotesModel quotesModel = snapshot.getValue(QuotesModel.class);
                    listquote.add(quotesModel);

                }

                qotesAdapter = new QotesAdapter(getApplicationContext(),listquote);
                recyclerView.setAdapter(qotesAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}


