package com.prism.prismproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.prism.prismproject.constant.Constant;
import com.prism.prismproject.object.Nintendo64;

public class Nintendo64ListAdapter extends DashboardListAdapter{
    private Nintendo64 nintendo64;
    private Context context;

    public Nintendo64ListAdapter(Nintendo64 nintendo64, Context context){
        this.nintendo64 = nintendo64;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull final DashboardListViewHolder holder, final int i) {
        holder.consoleName.setText(nintendo64.getConsole().getNome());
        holder.gameImage.setImageDrawable(context.getDrawable(nintendo64.getConsole().getJogos().get(i).getDrawableId()));
        holder.gameName.setText(nintendo64.getConsole().getJogos().get(i).getNome());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, nintendo64.getConsole().getJogos().get(i).getNome() + " clicado", Toast.LENGTH_SHORT).show();

                SendSSHCommands ssh = new SendSSHCommands(Constant.PAGE_NINTENDO_64);
                ssh.setLoading(holder.loading);
                ssh.execute("mario64.z64");
            }
        });
    }

    @Override
    public int getItemCount() {
        return nintendo64.getConsole().getJogos().size();
    }
}
