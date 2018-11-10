package com.prism.prismproject.object;

import java.security.PublicKey;

public class Jogo {
    private String nome;
    private int drawableId;
    private String archive;

    public Jogo(String nome, int drawableId, String archive){
        this.nome = nome;
        this.drawableId = drawableId;
        this.archive = archive;
    }

    public String getNome(){
        return this.nome;
    }

    public int getDrawableId(){
        return this.drawableId;
    }

    public String getArchive(){
        return this.archive;
    }
}
