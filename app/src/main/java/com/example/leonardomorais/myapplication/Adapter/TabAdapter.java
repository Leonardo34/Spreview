package com.example.leonardomorais.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.leonardomorais.myapplication.Fragments.FeedFragment;

import java.util.List;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class TabAdapter extends FragmentStatePagerAdapter{

    public String[] titulos = {"POSITIVOS", "NEGATIVOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FeedFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titulos[position];
    }
}
