package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.Nintendo64ListAdapter;
import com.prism.prismproject.constant.Constant;
import com.prism.prismproject.object.Nintendo64;

public class FragmentListNintendo64 extends FragmentListDashboard {
    private Nintendo64 nintendo64;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        nintendo64 = new Nintendo64();
    }

    @Override
    public void onResume() {
        super.onResume();

        DashboardListAdapter adapter = new Nintendo64ListAdapter(nintendo64, getContext());
        recyclerView.setAdapter(adapter);

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardListAdapter.SendSSHCommands ssh = new DashboardListAdapter.SendSSHCommands(Constant.STOP);
                ssh.execute("mupen64plus");
            }
        });
    }
}
