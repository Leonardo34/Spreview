package com.example.leonardomorais.myapplication;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.leonardomorais.myapplication.Adapter.TabAdapter;
import com.example.leonardomorais.myapplication.Helper.SlidingTabLayout;
import com.example.leonardomorais.myapplication.Model.Colunas;
import com.example.leonardomorais.myapplication.Model.Sprint;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private SlidingTabLayout slidingTabLayout;

    private ViewPager viewPager;

    private List<Colunas> colunas = new ArrayList<>();

    private FirebaseDatabase database;

    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        viewPager = (ViewPager) findViewById(R.id.vp_main_feed);

        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        database = FirebaseDatabase.getInstance();

        DatabaseReference reference = database.getReference().child("sprints");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot each : dataSnapshot.getChildren()){

                    Sprint sprint = each.getValue(Sprint.class);
                    colunas.clear();
                    for(Colunas coluna : sprint.getColunas()){
                        colunas.add(coluna);
                    }
                }

                tabAdapter.colunas = colunas;
                slidingTabLayout.setViewPager(viewPager);
                tabAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        tabAdapter = new TabAdapter(getSupportFragmentManager(), colunas);
        viewPager.setAdapter(tabAdapter);

    }

    public void onAddButtonClick(View v){

        int position = viewPager.getCurrentItem();

        Intent intent = new Intent(this, CadastroPostItActivity.class);
        intent.putExtra("posicaoColuna", String.valueOf(position));
        startActivity(intent);
    }
}
