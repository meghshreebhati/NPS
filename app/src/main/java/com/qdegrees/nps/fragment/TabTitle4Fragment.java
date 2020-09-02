package com.qdegrees.nps.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qdegrees.nps.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TabTitle4Fragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_title4, container, false);

        //getActivity().setTitle("View Survey");

        return root;
    }
}