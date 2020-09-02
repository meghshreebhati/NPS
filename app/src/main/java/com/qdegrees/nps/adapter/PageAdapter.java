package com.qdegrees.nps.adapter;

import com.qdegrees.nps.fragment.TabTitle1Fragment;
import com.qdegrees.nps.fragment.TabTitle2Fragment;
import com.qdegrees.nps.fragment.TabTitle3Fragment;
import com.qdegrees.nps.fragment.TabTitle4Fragment;
import com.qdegrees.nps.fragment.TabTitle5Fragment;
import com.qdegrees.nps.fragment.TabTitle6Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabTitle1Fragment();
            case 1:
                return new TabTitle2Fragment();
            case 2:
                return new TabTitle3Fragment();
            case 3:
                return new TabTitle4Fragment();
            case 4:
                return new TabTitle5Fragment();
            case 5:
                return new TabTitle6Fragment();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
