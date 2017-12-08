package com.example.leonardomorais.myapplication.Model;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class PostIts {

    private String descricao;

    private String cor;

    public PostIts(){

    }

    public PostIts(String descricao, String cor){
        this.descricao = descricao;
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
