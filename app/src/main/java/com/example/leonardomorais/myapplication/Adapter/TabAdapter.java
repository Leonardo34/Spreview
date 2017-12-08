package com.example.leonardomorais.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.leonardomorais.myapplication.Fragments.EmptyFeedFragment;
import com.example.leonardomorais.myapplication.Fragments.FeedFragment;
import com.example.leonardomorais.myapplication.Model.Colunas;
import com.example.leonardomorais.myapplication.Model.PostIts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class TabAdapter extends FragmentStatePagerAdapter{

    public List<Colunas> colunas;
    public List<PostIts> postIts = new ArrayList<>();
    public TabAdapter(FragmentManager fm, List<Colunas> colunas) {

        super(fm);
        this.colunas = colunas;
    }

    @Override
    public Fragment getItem(int position) {
        postIts = colunas.get(position).getPostIts();
        postIts.removeAll(Collections.singleton(null));

        if(postIts.size() <= 1){
            Fragment fragment = new EmptyFeedFragment();
            return fragment;
        }
        postIts.remove(0);
        Fragment fragment = new FeedFragment(postIts, position);
        return fragment;
    }

    @Override
    public int getCount() {
        return colunas.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return colunas.get(position).getNome();
    }

    @Override
    public int getItemPosition(Object object){
        return POSITION_NONE;
    }
}
