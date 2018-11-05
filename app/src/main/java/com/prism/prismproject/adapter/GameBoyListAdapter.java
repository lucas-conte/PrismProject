package com.prism.prismproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.prism.prismproject.object.GameBoyAdvance;
import com.prism.prismproject.object.PlayStation1;

public class GameBoyListAdapter extends DashboardListAdapter{
    private GameBoyAdvance gameBoyAdvance;
    private Context context;

    public GameBoyListAdapter(GameBoyAdvance gameBoyAdvance, Context context){
        this.gameBoyAdvance = gameBoyAdvance;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardListViewHolder holder, final int i) {
        holder.consoleName.setText(gameBoyAdvance.getConsole().getNome());
        holder.gameImage.setImageDrawable(context.getDrawable(gameBoyAdvance.getConsole().getJogos().get(i).getDrawableId()));
        holder.gameName.setText(gameBoyAdvance.getConsole().getJogos().get(i).getNome());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, gameBoyAdvance.getConsole().getJogos().get(i).getNome() + " clicado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameBoyAdvance.getConsole().getJogos().size();
    }
}
