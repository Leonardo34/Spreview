package com.example.leonardomorais.myapplication.Adapter;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leonardomorais.myapplication.FeedActivity;
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.R;

import java.util.List;

/**
 * Created by alexia.dorneles on 07/12/2017.
 */

public class PostItsAdapter extends BaseAdapter {

    private List<PostIts> postItsList;

    public PostItsAdapter(List<PostIts> postItsList) {
        this.postItsList = postItsList;
    }

    @Override
    public int getCount() {
        return postItsList.size();
    }

    @Override
    public Object getItem(int i) {
        return postItsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_it_visualization, viewGroup, false);

        PostIts postIts = postItsList.get(i);

        TextView tvDescricaoPostIt = view.findViewById(R.id.tv_descricao_post_it);

        tvDescricaoPostIt.setText(postIts.getDescricao());
        tvDescricaoPostIt.setBackgroundColor(Color.parseColor(postIts.getCor()));

        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_post_it_visualization);

        ll.setBackgroundColor(Color.parseColor(postIts.getCor()));
        return view;
    }
}
