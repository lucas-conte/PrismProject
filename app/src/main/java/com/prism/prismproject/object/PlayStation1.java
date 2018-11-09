package com.prism.prismproject.object;

import com.prism.prismproject.R;

import java.util.ArrayList;

public class PlayStation1 {
    private Console playStation;

    public PlayStation1(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Jackie Chan Stuntmaster", R.drawable.ps1_jackiechan);
        lista.add(jogo);
        jogo = new Jogo("Chrono Cross", R.drawable.ps1_chronocross);
        lista.add(jogo);
        jogo = new Jogo("Grand Theft Auto", R.drawable.ps1_grandtheftauto);
        lista.add(jogo);

        playStation = new Console("PlayStation 1", lista);
    }

    public Console getConsole(){
        return playStation;
    }
}
