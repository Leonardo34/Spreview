package com.example.leonardomorais.myapplication.Model;

import java.util.List;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class Colunas {

    private String nome;

    private List<PostIts> postIts;

    private String key;

    private String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PostIts> getPostIts() {
        return postIts;
    }

    public void setPostIts(List<PostIts> postItsList) {
        this.postIts = postItsList;
    }
}
