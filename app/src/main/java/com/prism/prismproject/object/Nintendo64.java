package com.prism.prismproject.object;

import com.prism.prismproject.R;

import java.util.ArrayList;

public class Nintendo64 {
    private Console gameBoy;

    public Nintendo64(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Super Mario 64", R.drawable.n64_supermario64);
        lista.add(jogo);
        jogo = new Jogo("Super Smash Bros", R.drawable.n64_supersmashbros);
        lista.add(jogo);
        jogo = new Jogo("Donkey Kong 64", R.drawable.n64_donkeykong);
        lista.add(jogo);

        gameBoy = new Console("Nintendo 64", lista);
    }

    public Console getConsole(){
        return gameBoy;
    }
}
