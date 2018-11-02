package com.prism.prismproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.prism.prismproject.R;
import com.prism.prismproject.constant.Constant;
import com.prism.prismproject.fragment.FragmentListDashboard;

public class ViewPagerDashboardAdapter extends FragmentStatePagerAdapter{
    private Context context;

    public ViewPagerDashboardAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case Constant.PAGE_SUPERNINTENDO:
                return new FragmentListDashboard();
            case Constant.PAGE_MEGADRIVE:
                return new FragmentListDashboard();
            case Constant.PAGE_PS1:
                return new FragmentListDashboard();
            default:
                return new FragmentListDashboard();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getResources().getString(R.string.supernintendo);
            case 1:
                return context.getResources().getString(R.string.megadrive);
            case 2:
                return context.getResources().getString(R.string.ps1);
            default:
                return context.getResources().getString(R.string.supernintendo);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
