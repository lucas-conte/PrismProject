package com.prism.prismproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.prism.prismproject.object.SuperNintendo;

public class SuperNintendoListAdapter extends DashboardListAdapter{
    private SuperNintendo superNintendo;
    private Context context;

    public SuperNintendoListAdapter(SuperNintendo superNintendo, Context context){
        this.superNintendo = superNintendo;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull final DashboardListViewHolder holder, final int i) {
        holder.consoleName.setText(superNintendo.getConsole().getNome());
        holder.gameImage.setImageDrawable(context.getDrawable(superNintendo.getConsole().getJogos().get(i).getDrawableId()));
        holder.gameName.setText(superNintendo.getConsole().getJogos().get(i).getNome());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, superNintendo.getConsole().getJogos().get(i).getNome() + " clicado", Toast.LENGTH_SHORT).show();

                SendSSHCommands ssh = new SendSSHCommands();
                ssh.setLoading(holder.loading);
                ssh.execute("n64", "mario64.z64");
            }
        });
    }

    @Override
    public int getItemCount() {
        return superNintendo.getConsole().getJogos().size();
    }
}
