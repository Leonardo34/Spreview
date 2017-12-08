package com.example.leonardomorais.myapplication.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.leonardomorais.myapplication.Fragments.FeedFragment;
import com.example.leonardomorais.myapplication.Model.Colunas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class TabAdapter extends FragmentStatePagerAdapter{

    public List<Colunas> colunas;

    public TabAdapter(FragmentManager fm, List<Colunas> colunas) {

        super(fm);
        this.colunas = colunas;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FeedFragment(colunas.get(position).getPostIts());
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
