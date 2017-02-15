package com.example.alazh.mycv;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Layout;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;


public class Education extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Education() {
        // Required empty public constructor
    }


    public void onStart(){
        super.onStart();

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i= getActivity().getIntent();
       // Bundle args = i.getBundleExtra("BUNDLE");
       final ArrayList<MainActivity.Edu> edu=(ArrayList<MainActivity.Edu>) i.getExtras().getSerializable("education");
        ArrayAdapter<MainActivity.Edu> eduAdapter =
                new ArrayAdapter<MainActivity.Edu>(getActivity(), 0, edu) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        MainActivity.Edu currentEdu=edu.get(position);
                        if(convertView == null) {
                            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_row, null, false);
                            TextView ye=(TextView) getActivity().findViewById(R.id.yearE);
                            TextView de=(TextView) getActivity().findViewById(R.id.degE);
                            TextView spe=(TextView) getActivity().findViewById(R.id.specE);
                            TextView ist=(TextView) getActivity().findViewById(R.id.institE);
                            ye.setText(currentEdu.year);
                            de.setText(currentEdu.degree);
                            spe.setText(currentEdu.speciality);
                            ist.setText(currentEdu.instituation);
                        }
                        return convertView;
                    }
                };
        ListView listView=(ListView) getActivity().findViewById(R.id.list);
        listView.setAdapter(eduAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       return inflater.inflate(R.layout.fragment_education, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onClickedu(View view);
    }
}
