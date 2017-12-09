package com.example.leonardomorais.myapplication.Model;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class PostIts {

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
}
