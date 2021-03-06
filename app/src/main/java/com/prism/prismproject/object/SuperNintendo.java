package com.prism.prismproject.object;

import com.prism.prismproject.R;

import java.util.ArrayList;

public class SuperNintendo{
    private Console superNintendo;

    public SuperNintendo(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Super Mario World", R.drawable.snes_supermarioworld, "supermario.smc");
        lista.add(jogo);
        jogo = new Jogo("Super Mario Kart", R.drawable.snes_supermariokart, "mariokart.smc");
        lista.add(jogo);
        jogo = new Jogo("Mighty Morphin Power Rangers", R.drawable.snes_powerrangers, "powerrangers.smc");
        lista.add(jogo);

        superNintendo = new Console("Super Nintendo", lista);
    }

    public Console getConsole(){
        return superNintendo;
    }
}
