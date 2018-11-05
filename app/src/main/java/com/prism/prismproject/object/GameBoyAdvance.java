package com.prism.prismproject.object;

import com.prism.prismproject.R;

import java.util.ArrayList;

public class GameBoyAdvance {
    private Console gameBoy;

    public GameBoyAdvance(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Metroid: Fusion", R.drawable.gb_metroid);
        lista.add(jogo);
        jogo = new Jogo("Pokemon: Sapphire Version", R.drawable.gb_pokemon);
        lista.add(jogo);
        jogo = new Jogo("Zelda: A Link To The Past", R.drawable.gb_zelda);
        lista.add(jogo);

        gameBoy = new Console("Game Boy Advance", lista);
    }

    public Console getConsole(){
        return gameBoy;
    }
}
