package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.GameBoyListAdapter;
import com.prism.prismproject.object.GameBoyAdvance;

public class FragmentListGameBoy extends FragmentListDashboard {
    private GameBoyAdvance gameBoyAdvance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameBoyAdvance = new GameBoyAdvance();
    }

    @Override
    public void onResume() {
        super.onResume();

        DashboardListAdapter adapter = new GameBoyListAdapter(gameBoyAdvance, getContext());
        recyclerView.setAdapter(adapter);
    }
}
