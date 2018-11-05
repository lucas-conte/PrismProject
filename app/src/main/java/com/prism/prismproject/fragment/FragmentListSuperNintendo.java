package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.SuperNintendoListAdapter;
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
    }
}
