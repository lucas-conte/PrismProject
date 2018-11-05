package com.prism.prismproject.object;

import com.prism.prismproject.R;

import java.util.ArrayList;

public class PlayStation1 {
    private Console playStation;

    public PlayStation1(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Crash Bandicoot Trilogy", R.drawable.ps_crash);
        lista.add(jogo);
        jogo = new Jogo("Driver", R.drawable.ps_driver);
        lista.add(jogo);
        jogo = new Jogo("Grand Theft Auto", R.drawable.ps_gta);
        lista.add(jogo);

        playStation = new Console("PlayStation 1", lista);
    }

    public Console getConsole(){
        return playStation;
    }
}
