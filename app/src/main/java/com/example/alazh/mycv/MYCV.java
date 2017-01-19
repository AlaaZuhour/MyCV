package com.example.alazh.mycv;


import android.app.Activity;
import android.app.Fragment;

import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

public class MYCV extends Activity implements Personal.OnFragmentInteractionListener {
    public static int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentmanager= getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();


             Personal per =new Personal();
            fragmentTransaction.replace(android.R.id.content ,per);
        fragmentTransaction.commit();


    }

    @Override
    public void onClick(View view) {

    }
}

