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
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.Model.Sprint;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

    private FirebaseAuth auth;

    @Override
    protected  void onResume(){
        auth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = auth.getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        super.onResume();
    }

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

                    Colunas coluna;
                    PostIts postIt;

                    Sprint sprint = each.getValue(Sprint.class);
                    sprint.setKey(each.getKey());

                    colunas.clear();

                    for(DataSnapshot eachSprintField : each.getChildren()){
                        if(!"name".equalsIgnoreCase(eachSprintField.getKey())){
                            for(DataSnapshot eachColumn : eachSprintField.getChildren()){
                                coluna = eachColumn.getValue(Colunas.class);
                                coluna.setKey(eachColumn.getKey());
                                coluna.getPostIts().clear();
                                for(DataSnapshot eachColumnField : eachColumn.getChildren()){
                                    if(!"nome".equalsIgnoreCase(eachColumnField.getKey())){
                                        for(DataSnapshot eachPostIt : eachColumnField.getChildren()){
                                            postIt = eachPostIt.getValue(PostIts.class);
                                            postIt.setKey(eachPostIt.getKey());
                                            coluna.getPostIts().add(postIt);
                                        }
                                    }
                                }
                                colunas.add(coluna);
                            }
                        }
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

    public void onLogoutButtonClick(View v){

        auth = FirebaseAuth.getInstance();

        auth.signOut();

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
