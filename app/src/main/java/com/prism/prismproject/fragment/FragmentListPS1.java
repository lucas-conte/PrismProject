package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.PlayStationListAdapter;
import com.prism.prismproject.constant.Constant;
import com.prism.prismproject.object.PlayStation1;

public class FragmentListPS1 extends FragmentListDashboard{
    private PlayStation1 playStation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playStation = new PlayStation1();
    }

    @Override
    public void onResume() {
        super.onResume();

        DashboardListAdapter adapter = new PlayStationListAdapter(playStation, getContext());
        recyclerView.setAdapter(adapter);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardListAdapter.SendSSHCommands ssh = new DashboardListAdapter.SendSSHCommands(Constant.STOP, getContext());
                ssh.execute("retroarch");
            }
        });
    }
}
