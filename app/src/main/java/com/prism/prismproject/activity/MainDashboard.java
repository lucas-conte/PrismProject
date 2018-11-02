package com.prism.prismproject.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prism.prismproject.R;
import com.prism.prismproject.adapter.DashboardListAdapter;
import com.prism.prismproject.adapter.ViewPagerDashboardAdapter;

public class MainDashboard extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

        viewPager = findViewById(R.id.vp_dashboard);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ViewPagerDashboardAdapter adapter = new ViewPagerDashboardAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
    }
}
