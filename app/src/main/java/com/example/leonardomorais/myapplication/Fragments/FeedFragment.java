package com.example.leonardomorais.myapplication.Fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.leonardomorais.myapplication.Adapter.PostItsAdapter;
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment implements View.OnClickListener {

    private ListView listView;
    private PostItsAdapter adapter;
    private List<PostIts> postItsList = new ArrayList<>();
    private int posicaoColuna;

    public FeedFragment() {
    }


    public FeedFragment(List<PostIts> postItsList, int posicaoColuna) {
        this.postItsList = postItsList;
        this.posicaoColuna = posicaoColuna;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        listView = view.findViewById(R.id.lv_feed_fragment);

        adapter = new PostItsAdapter(postItsList, this);

        listView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(final View view) {
        new AlertDialog.Builder(view.getContext())
                .setMessage("Tem certeza que deseja excluir este post it?")
                .setTitle("Excluir Post It")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int position = listView.getPositionForView(view);
                        PostIts postIts = postItsList.get(position);
                        excluirPostIt(postIts, posicaoColuna, position);
                        Toast.makeText(view.getContext(), "PostIt excluído", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    private void excluirPostIt(final PostIts postIts, int posicaoColuna, int posicaoPostIt) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference()
                .child("sprints")
                .child("12")
                .child("colunas")
                .child(String.valueOf(posicaoColuna))
                .child("postIts")
                .child(String.valueOf(posicaoPostIt));

        reference.removeValue();
        postItsList.remove(postIts);
        adapter.notifyDataSetChanged();
    }
}
