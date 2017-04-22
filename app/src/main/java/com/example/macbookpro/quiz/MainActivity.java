package com.example.macbookpro.quiz;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    FragmentB af;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        af = new FragmentB();
        ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frame,af);
        ft.commit();
    }
}
