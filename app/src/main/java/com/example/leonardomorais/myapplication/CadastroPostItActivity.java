package com.example.leonardomorais.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.leonardomorais.myapplication.Model.Colunas;
import com.example.leonardomorais.myapplication.Model.Sprint;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

public class CadastroPostItActivity extends AppCompatActivity {

    private EditText textoPostIt;

    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_it_edition);
        textoPostIt = findViewById(R.id.et_cadastro_postit);

        final HSLColorPicker colorPicker = (HSLColorPicker)findViewById(R.id.cadastro_color_picker);
        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener(){
            @Override
            public void onColorSelected(int color){
                textoPostIt.setBackgroundColor(color);
            }
        });

        database = FirebaseDatabase.getInstance();

        DatabaseReference reference = database.getReference()
                .child("sprints")
                .child("12")
                .child("colunas");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot each : dataSnapshot.getChildren()){

                    Colunas coluna = each.getValue(Colunas.class);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onAddButtonClick(View v){


    }

}
