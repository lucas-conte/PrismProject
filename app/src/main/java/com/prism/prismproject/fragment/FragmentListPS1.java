package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.PlayStationListAdapter;
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
    }
}
