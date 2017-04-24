package com.example.haams.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by haams on 2017-04-24.
 */

public class MainStateAdapter extends FragmentStatePagerAdapter {

    private int pageNum;

    public MainStateAdapter(FragmentManager fm, int pageNum) {
        super(fm);
        this.pageNum = pageNum;
    }

    public static Fragment getFragmentInstance(int pageNum) {
        Fragment fragment = null;
        switch (pageNum) {
            case 0:
                fragment = First_Tab_Fragment.newInstance("Tab", "Main");
                break;
            case 1:
                fragment = Second_Tab_Fragment.newInstance("Tab", "Chat");
                break;
            case 2:
                fragment = Third_Tab_Fragment.newInstance("Tab", "ImgUpload");
                break;
            case 3:
                fragment = Fourth_Tab_Fragment.newInstance("Tab", "Configuration");
                break;
        }
        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragmentInstance(position);
    }

    @Override
    public int getCount() {
        return pageNum;
    }
}
