package com.prism.prismproject.object;

import java.security.PublicKey;

public class Jogo {
    private String nome;
    private int drawableId;

    public Jogo(String nome, int drawableId){
        this.nome = nome;
        this.drawableId = drawableId;
    }

    public String getNome(){
        return this.nome;
    }

    public int getDrawableId(){
        return this.drawableId;
    }
}
