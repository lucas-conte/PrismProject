package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.SuperNintendoListAdapter;
import com.prism.prismproject.constant.Constant;
import com.prism.prismproject.object.SuperNintendo;

public class FragmentListSuperNintendo extends FragmentListDashboard{
    private SuperNintendo superNintendo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        superNintendo = new SuperNintendo();
    }

    @Override
    public void onResume() {
        super.onResume();

        DashboardListAdapter adapter = new SuperNintendoListAdapter(superNintendo, getContext());
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
