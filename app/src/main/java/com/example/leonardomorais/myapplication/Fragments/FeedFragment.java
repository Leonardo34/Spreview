package com.example.leonardomorais.myapplication.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.leonardomorais.myapplication.Adapter.PostItsAdapter;
import com.example.leonardomorais.myapplication.CadastroPostItActivity;
import com.example.leonardomorais.myapplication.FeedActivity;
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment implements View.OnClickListener {

    private ListView listView;
    private PostItsAdapter adapter;
    private List<PostIts> postItsList = new ArrayList<>();

    public FeedFragment() {
    }


    public FeedFragment(List<PostIts> postItsList) {
        this.postItsList = postItsList;
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
                        postItsList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(view.getContext(), "PostIt excluído", Toast.LENGTH_SHORT).show();
                        // TODO: exclusão do firebase aqui
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
}
