package com.example.macbookpro.quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbookpro on 22.04.17.
 */

public class FragmentA extends Fragment {

    public DrawView second;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        second = new DrawView(getActivity());
        return second;
    }
}