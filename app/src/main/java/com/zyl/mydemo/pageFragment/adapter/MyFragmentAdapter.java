package com.zyl.mydemo.pageFragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yinglong.zhang on 2016/7/12.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragments;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    public void setList(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
