package com.example.leonardomorais.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.leonardomorais.myapplication.Fragments.FeedFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class TabAdapter extends FragmentStatePagerAdapter{

    public List<String> titulos = new ArrayList<>();

    public TabAdapter(FragmentManager fm, List<String> colunas) {

        super(fm);
        titulos = colunas;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FeedFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return titulos.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titulos.get(position);
    }
}
