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
import com.example.manav.devkon.Quora.AddQuestion;
import com.example.manav.devkon.Quora.Recent;
import com.example.manav.devkon.Quora.TopQuestion;
import com.example.manav.devkon.R;
import com.example.manav.devkon.Chat.Resources;


public class QuoraHolder extends Fragment {

    public QuoraHolder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_quora, container, false);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                view.findViewById(R.id.navigation_quora);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.addquest:
                                selectedFragment = new AddQuestion();
                                break;
                            case R.id.topquest:
                                selectedFragment = new TopQuestion();
                                break;
                            case R.id.recent:
                                selectedFragment = new Recent();
                                break;
                        }
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.quora_holder, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.quora_holder, new AddQuestion());
        transaction.commit();
        return view;
    }

}
