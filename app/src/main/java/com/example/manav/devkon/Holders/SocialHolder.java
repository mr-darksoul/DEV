package com.example.manav.devkon.Holders;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.manav.devkon.Chat.Home;
import com.example.manav.devkon.Chat.Notifications;
import com.example.manav.devkon.Chat.Resources;
import com.example.manav.devkon.R;
import com.example.manav.devkon.Social.College;
import com.example.manav.devkon.Social.Global;
import com.example.manav.devkon.Social.Trending;


public class SocialHolder extends Fragment {

    public SocialHolder() {
        // Required empty public constructor
    }

    public static SocialHolder newInstance(String param1, String param2) {
        SocialHolder fragment = new SocialHolder();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_social, container, false);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                view.findViewById(R.id.navigation_social);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.collegelocal:
                                selectedFragment = new College();
                                break;
                            case R.id.global:
                                selectedFragment = new Global();
                                break;
                            case R.id.trending:
                                selectedFragment = new Trending();
                                break;
                        }
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.social_holder, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.social_holder, new College());
        transaction.commit();
        return view;
    }
}
