package com.example.alazh.mycv;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Training extends Fragment {


    private OnFragmentInteractionListener mListener;

    public Training() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_training, container, false);
        Intent i= getActivity().getIntent();

        final ArrayList<MainActivity.Train> tran= i.getExtras().getParcelableArrayList("training");

        ArrayAdapter<MainActivity.Train> tranAdapter =
                new ArrayAdapter<MainActivity.Train>(getActivity(), 0, tran) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        MainActivity.Train currentran=tran.get(position);
                        if(convertView == null)
                            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_row, null, false);
                        TextView ye=(TextView) convertView.findViewById(R.id.yearE);
                        TextView de=(TextView) convertView.findViewById(R.id.degE);
                        TextView spe=(TextView) convertView.findViewById(R.id.specE);
                        TextView ist=(TextView) convertView.findViewById(R.id.institE);
                        ye.setText(currentran.comp);
                        de.setText(currentran.top);
                        spe.setText(currentran.hor);
                        ist.setText(currentran.dura);

                        return convertView;
                    }
                };
        final ListView listView=(ListView) rootView.findViewById(R.id.listT);
        listView.setAdapter(tranAdapter);

        return rootView;
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

    }
}
