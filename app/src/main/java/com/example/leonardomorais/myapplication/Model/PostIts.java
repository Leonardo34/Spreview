package com.example.leonardomorais.myapplication.Model;

import java.io.Serializable;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class PostIts implements Serializable {

    private String descricao;

    private String cor;

    private String key;

    private String creator;

    private String getKey() {
        return key;
    }

    public String getPublicKey(){
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public PostIts(){

    }

    public PostIts(String descricao, String cor, String creator){
        this.descricao = descricao;
        this.cor = cor;
        this.creator = creator;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

//    @Override
//    public boolean equals(Object object) {
//        PostIts postIts = (PostIts) object;
//        return this.descricao.equals(postIts.getDescricao())
//                && this.cor.equals(postIts.getCor())
//                && this.creator.equalsIgnoreCase(postIts.getCreator());
//    }
}
