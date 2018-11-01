package com.prism.prismproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prism.prismproject.R;
import com.prism.prismproject.adapter.DashboardListAdapter;

public class MainDashboard extends AppCompatActivity {
    private RecyclerView rvDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        rvDashboard = findViewById(R.id.rv_dashboard);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvDashboard.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();

        DashboardListAdapter adapter = new DashboardListAdapter();
        rvDashboard.setAdapter(adapter);
    }
}
