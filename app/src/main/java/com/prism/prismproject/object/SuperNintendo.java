package com.prism.prismproject.object;

import com.prism.prismproject.R;
import com.prism.prismproject.constant.Constant;

import java.util.ArrayList;

public class SuperNintendo{
    private Console superNintendo;

    public SuperNintendo(){
        ArrayList<Jogo> lista = new ArrayList<>();
        Jogo jogo = new Jogo("Super Mario World", R.drawable.sn_supermario);
        lista.add(jogo);
        jogo = new Jogo("Super Mario Kart", R.drawable.sn_mariokart);
        lista.add(jogo);
        jogo = new Jogo("Bomberman", R.drawable.sn_bomberman);
        lista.add(jogo);

        superNintendo = new Console("Super Nintendo", lista);
    }

    public Console getConsole(){
        return superNintendo;
    }
}
