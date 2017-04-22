package com.example.macbookpro.quiz;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentB extends Fragment {
    View view;

    Button btnStartProgress;


    private long fileSize = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Lifecycle", "FragmentB: onCreateView");
        view = inflater.inflate(R.layout.fragment_b, null);

        addListenerOnButton();


        return view;
    }
    public void addListenerOnButton() {

        btnStartProgress = (Button) view.findViewById(R.id.btnStartProgress);
        btnStartProgress.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        final FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, new FragmentA(), "NewFragmentTag");
                        ft.commit();


                    }

                });
    }

    }





