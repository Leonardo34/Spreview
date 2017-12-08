package com.example.leonardomorais.myapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.leonardomorais.myapplication.Adapter.PostItsAdapter;
import com.example.leonardomorais.myapplication.FeedActivity;
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

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

        adapter = new PostItsAdapter(postItsList);

        listView.setAdapter(adapter);

        return view;
    }

}
