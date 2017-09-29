package com.example.manav.devkon.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> listFragments;

    public void addFragment(Fragment fragment , String string)
    {
        this.listFragments.add(fragment);
    }

    public SimpleFragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm);
        this.listFragments=listFragments;

    }



    @Override
    public Fragment getItem(int position) {
    return listFragments.get(position);
    }


    @Override
    public int getCount() {
        return listFragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//      Fragment fragment = getItem(position);
//            if (fragment instanceof FragmentBest){
//                return ((FragmentBest) fragment).getTAB_TYPE();
//            }
//             else if (fragment instanceof FragmentComb)
//            {
//                return ((FragmentComb)fragment).getTAB_TYPE();
//            }
//            return null;
//        }


    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}