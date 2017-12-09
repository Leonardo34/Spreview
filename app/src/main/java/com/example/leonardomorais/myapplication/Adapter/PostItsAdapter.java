package com.example.leonardomorais.myapplication.Adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.leonardomorais.myapplication.CadastroPostItActivity;
import com.example.leonardomorais.myapplication.Model.PostIts;
import com.example.leonardomorais.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

/**
 * Created by alexia.dorneles on 07/12/2017.
 */

public class PostItsAdapter extends BaseAdapter {

    private List<PostIts> postItsList;
    private View.OnClickListener onClickListener;
    private int posicaoColuna;

    private FirebaseUser user;

    public PostItsAdapter(List<PostIts> postItsList, View.OnClickListener onClickListener, int posicaoColuna) {
        this.postItsList = postItsList;
        this.onClickListener = onClickListener;
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        String teste = user.getUid();
        this.posicaoColuna = posicaoColuna;
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

        final PostIts postIts = postItsList.get(i);

        TextView tvDescricaoPostIt = view.findViewById(R.id.tv_descricao_post_it);

        tvDescricaoPostIt.setText(postIts.getDescricao());
        tvDescricaoPostIt.setBackgroundColor(Color.parseColor(postIts.getCor()));

        LinearLayout ll = (LinearLayout) view.findViewById(R.id.ll_post_it_visualization);

        ImageView ivEditPostIt = view.findViewById(R.id.iv_edit_post_it);
        ImageView ivDeletePostIt = view.findViewById(R.id.iv_delete_post_it);
        ivDeletePostIt.setOnClickListener(onClickListener);

        if (!postIts.getCreator().equalsIgnoreCase(user.getUid())) {
            ivEditPostIt.setVisibility(View.INVISIBLE);
            ivDeletePostIt.setVisibility(View.INVISIBLE);
        }

        ivEditPostIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CadastroPostItActivity.class);
                intent.putExtra("postIt", postIts);
                intent.putExtra("posicaoColuna", String.valueOf(posicaoColuna));
                view.getContext().startActivity(intent);
            }
        });

        ll.setBackgroundColor(Color.parseColor(postIts.getCor()));
        return view;
    }
}

