package com.example.byun.dots;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * Created by byun on 2018-03-14.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private String[] titleList;
    private List<Fragment> fragmentList;

    public TabPagerAdapter(FragmentManager fm, String[] titleList, List<Fragment> fragmentList) {
        super(fm);

        this.titleList = titleList;
        this.fragmentList = fragmentList;

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        return fragmentList.get(position);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList[position];
    }
}
