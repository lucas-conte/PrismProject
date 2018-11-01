package com.prism.prismproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prism.prismproject.R;

public class DashboardListAdapter extends RecyclerView.Adapter<DashboardListAdapter.DashboardListViewHolder>  {

    @NonNull
    @Override
    public DashboardListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.card_item, viewGroup, false);
        DashboardListViewHolder holder = new DashboardListViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardListViewHolder dashboardListViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class DashboardListViewHolder extends RecyclerView.ViewHolder{
        public ImageView gameImage;
        public TextView gameName;
        public TextView consoleName;

        public DashboardListViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImage = itemView.findViewById(R.id.iv_game);
            gameName = itemView.findViewById(R.id.tv_gamename);
            consoleName = itemView.findViewById(R.id.tv_consolename);
        }
    }
}
