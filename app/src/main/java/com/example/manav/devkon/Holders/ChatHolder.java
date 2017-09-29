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
import com.example.manav.devkon.R;
import com.example.manav.devkon.Chat.Resources;


public class ChatHolder extends Fragment {

    public ChatHolder() {
        // Required empty public constructor
    }

    public static ChatHolder newInstance(String param1, String param2) {
        ChatHolder fragment = new ChatHolder();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        final View view = inflater.inflate(R.layout.fragment_chat, container, false);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                view.findViewById(R.id.navigation_chat);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.chat:
                                selectedFragment = new Home();
                                break;
                            case R.id.resources:
                                selectedFragment = new Resources();
                                break;
                            case R.id.notification:
                                selectedFragment = new Notifications();
                                break;
                        }
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.chat_holder, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.chat_holder, new Home());
        transaction.commit();
        return view;
    }
}
