package com.example.alazh.mycv;


import android.app.Activity;
import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MYCV extends Activity  implements Personal.OnFragmentInteractionListener , Education.OnFragmentInteractionListener
                                         , Skills.OnFragmentInteractionListener, Training.OnFragmentInteractionListener{
    FragmentManager fragmentmanager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         fragmentmanager= getFragmentManager();
        fragmentTransaction = fragmentmanager.beginTransaction();
        Intent data = getIntent();
        //LinearLayout layout=new LinearLayout(this);
        Personal per =new Personal();
        fragmentTransaction.replace(android.R.id.content ,per);
        fragmentTransaction.commit();



    }


    @Override
    public void onClickper(View view) {
        FragmentManager fragmentmanager1;
        FragmentTransaction fragmentTransaction1;
        fragmentmanager1= getFragmentManager();
        fragmentTransaction1 = fragmentmanager1.beginTransaction();
        Education edu = new Education();

        fragmentTransaction1.replace(android.R.id.content ,edu);
        fragmentTransaction1.addToBackStack(null);
        fragmentTransaction1.commit();
    }

    @Override
    public void onClickedu(View view) {
        FragmentManager fragmentmanager1;
        FragmentTransaction fragmentTransaction1;
        fragmentmanager1= getFragmentManager();
        fragmentTransaction1 = fragmentmanager1.beginTransaction();
        Skills edu = new Skills();

        fragmentTransaction1.replace(android.R.id.content ,edu);
        fragmentTransaction1.addToBackStack(null);
        fragmentTransaction1.commit();
    }



    @Override
    public void onClickskil(View view) {
        FragmentManager fragmentmanager1;
        FragmentTransaction fragmentTransaction1;
        fragmentmanager1= getFragmentManager();
        fragmentTransaction1 = fragmentmanager1.beginTransaction();
        Training edu = new Training();

        fragmentTransaction1.replace(android.R.id.content ,edu);
        fragmentTransaction1.addToBackStack(null);
        fragmentTransaction1.commit();
    }
}

