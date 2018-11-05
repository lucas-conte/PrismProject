package com.prism.prismproject.object;

import java.util.ArrayList;

public class Console {
    private String nome;
    private ArrayList<Jogo> jogos;

    public Console(String nome, ArrayList<Jogo> jogos) {
        this.nome = nome;
        this.jogos = jogos;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Jogo> getJogos(){
        return this.jogos;
    }
}
