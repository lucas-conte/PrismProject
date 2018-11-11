package com.prism.prismproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.prism.prismproject.constant.Constant;
import com.prism.prismproject.object.PlayStation1;

public class PlayStationListAdapter extends DashboardListAdapter {
    private PlayStation1 playStation;
    private Context context;

    public PlayStationListAdapter(PlayStation1 playStation, Context context){
        this.playStation = playStation;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull final DashboardListViewHolder holder, final int i) {
        holder.consoleName.setText(playStation.getConsole().getNome());
        holder.gameImage.setImageDrawable(context.getDrawable(playStation.getConsole().getJogos().get(i).getDrawableId()));
        holder.gameName.setText(playStation.getConsole().getJogos().get(i).getNome());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, playStation.getConsole().getJogos().get(i).getNome() + " clicado", Toast.LENGTH_SHORT).show();

                SendSSHCommands ssh = new SendSSHCommands(Constant.PAGE_PS1, context);
                ssh.setLoading(holder.loading);
                ssh.execute(playStation.getConsole().getJogos().get(i).getArchive());
            }
        });
    }

    @Override
    public int getItemCount() {
        return playStation.getConsole().getJogos().size();
    }
}
