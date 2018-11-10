package com.prism.prismproject.object;

import com.prism.prismproject.R;

import java.util.ArrayList;

public class Nintendo64 {
    private Console nintendo64;

    public Nintendo64(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Super Mario 64", R.drawable.n64_supermario64, "mario64.z64");
        lista.add(jogo);
        jogo = new Jogo("Super Smash Bros", R.drawable.n64_supersmashbros, "smashbros.z64");
        lista.add(jogo);
        jogo = new Jogo("Donkey Kong 64", R.drawable.n64_donkeykong, "donkeykong.z64");
        lista.add(jogo);

        nintendo64 = new Console("Nintendo 64", lista);
    }

    public Console getConsole(){
        return nintendo64;
    }
}
