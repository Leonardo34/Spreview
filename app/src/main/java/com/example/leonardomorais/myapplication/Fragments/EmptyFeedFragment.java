package com.example.leonardomorais.myapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leonardomorais.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmptyFeedFragment extends Fragment {


    public EmptyFeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_empty_feed, container, false);
    }

}
