package com.example.manav.devkon;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.manav.devkon.Adapters.SimpleFragmentPagerAdapter;
import com.example.manav.devkon.Holders.ChatHolder;
import com.example.manav.devkon.Holders.QuoraHolder;
import com.example.manav.devkon.Holders.SocialHolder;
import com.h6ah4i.android.tablayouthelper.TabLayoutHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayoutHelper tabLayoutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.main_viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tabLayout);

        List<Fragment> tabFragments = new ArrayList<Fragment>();
        tabFragments.add(new SocialHolder());
        tabFragments.add(new ChatHolder());
        tabFragments.add(new QuoraHolder());

        SimpleFragmentPagerAdapter fragmentPageAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(),tabFragments);

        viewPager.setAdapter(fragmentPageAdapter);
        viewPager.setCurrentItem(1);
        fragmentPageAdapter.notifyDataSetChanged();
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        tabLayoutHelper = new TabLayoutHelper(tabLayout,viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.leak_canary_icon);
        tabLayout.getTabAt(1).setText("DEVKON");
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher_round);
        tabLayoutHelper.setAutoAdjustTabModeEnabled(true);
    }
}
