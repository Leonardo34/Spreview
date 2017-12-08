package com.example.leonardomorais.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.leonardomorais.myapplication.Model.Colunas;
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.Model.Sprint;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

import java.util.HashMap;
import java.util.Map;

public class CadastroPostItActivity extends AppCompatActivity {

    private EditText textoPostIt;

    private FirebaseDatabase database;

    private DatabaseReference reference;

    private String lastKey = "0";

    private HSLColorPicker colorPicker;

    private Map<String, PostIts> postItsMap = new HashMap<>();

    private String corSalvar = "ff40bfbf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_it_edition);
        textoPostIt = findViewById(R.id.et_cadastro_postit);

        colorPicker = (HSLColorPicker)findViewById(R.id.cadastro_color_picker);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener(){
            @Override
            public void onColorSelected(int color){
                corSalvar = Integer.toHexString(color);
                textoPostIt.setBackgroundColor(color);
            }
        });

        database = FirebaseDatabase.getInstance();

       reference = database.getReference()
                .child("sprints")
                .child("12")
                .child("colunas")
                .child(getIntent().getStringExtra("posicaoColuna"));

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot each : dataSnapshot.getChildren()){
                    if(!"nome".equals(each.getKey())) {
                        for(DataSnapshot cadaPostIt : each.getChildren()){
                            PostIts postIt = cadaPostIt.getValue(PostIts.class);
                            postItsMap.put(cadaPostIt.getKey(), postIt);
                            lastKey = cadaPostIt.getKey();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onAddButtonClick(View v){


        Drawable background = textoPostIt.getBackground();
        PostIts novoPostIt = new PostIts(textoPostIt.getText().toString(), "#" + corSalvar);
        postItsMap.put(String.valueOf(Integer.valueOf(lastKey) + 1), novoPostIt);
        reference.child("postIts").setValue(postItsMap);

        Intent intent = new Intent(this, FeedActivity.class);
        startActivity(intent);
    }

}
