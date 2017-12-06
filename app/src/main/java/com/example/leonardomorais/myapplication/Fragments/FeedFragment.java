package com.example.leonardomorais.myapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.leonardomorais.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> textoPostits;

    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        textoPostits = new ArrayList<>();
        textoPostits.add("item 1");
        textoPostits.add("item 2");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        listView = view.findViewById(R.id.lv_feed_fragment);

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, textoPostits);

        listView.setAdapter(adapter);

        return view;
    }

}
