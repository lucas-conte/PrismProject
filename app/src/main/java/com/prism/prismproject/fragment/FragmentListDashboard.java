package com.prism.prismproject.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prism.prismproject.R;
import com.prism.prismproject.adapter.DashboardListAdapter;

public class FragmentListDashboard extends Fragment{
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_list_dashboard, container, false);
        recyclerView = viewGroup.findViewById(R.id.rv_dashboard);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return viewGroup;
    }

    @Override
    public void onResume() {
        super.onResume();

        DashboardListAdapter adapter = new DashboardListAdapter();
        recyclerView.setAdapter(adapter);
    }
}
