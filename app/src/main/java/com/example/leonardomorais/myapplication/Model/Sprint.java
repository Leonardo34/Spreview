package com.example.leonardomorais.myapplication.Model;

import java.util.List;

/**
 * Created by lucasdamaceno on 06/12/17.
 */

public class Sprint {

    private String name;

    private List<Colunas> colunas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Colunas> getColunas() {
        return colunas;
    }

    public void setColunas(List<Colunas> colunas) {
        this.colunas = colunas;
    }
}
