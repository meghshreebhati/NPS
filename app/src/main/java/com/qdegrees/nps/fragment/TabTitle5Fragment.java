package com.qdegrees.nps.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.qdegrees.nps.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TabTitle5Fragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_title5, container, false);

        //getActivity().setTitle("View Survey");

        Spinner spinDateFilter = root.findViewById(R.id.spinDateFilter3);
        String[] dateFilter = {"Leatest 5","Last Week","Last Month","Last Year"};
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, dateFilter);
        spinDateFilter.setAdapter(dateAdapter);

        return root;
    }
}