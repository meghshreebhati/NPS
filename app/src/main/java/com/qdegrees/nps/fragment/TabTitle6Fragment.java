package com.qdegrees.nps.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mordred.wordcloud.WordCloud;
import com.qdegrees.nps.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import static android.bluetooth.BluetoothHidDeviceAppQosSettings.MAX;

public class TabTitle6Fragment extends Fragment {

    ArrayList wordNameList = new ArrayList<String>();

    TextView tvWorldCloud1,tvWorldCloud2;
    LinearLayout llWorldCloud1,llWorldCloud2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_title6, container, false);

        //getActivity().setTitle("View Survey");

        llWorldCloud1 = root.findViewById(R.id.linearLayoutWorld1);
        llWorldCloud2 = root.findViewById(R.id.linearLayoutWorld2);

        tvWorldCloud1 = root.findViewById(R.id.tvWorldCloud1);
        tvWorldCloud1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llWorldCloud1.setVisibility(View.VISIBLE);
                llWorldCloud2.setVisibility(View.GONE);
            }
        });

        tvWorldCloud2 = root.findViewById(R.id.tvWorldCloud2);
        tvWorldCloud2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llWorldCloud2.setVisibility(View.VISIBLE);
                llWorldCloud1.setVisibility(View.GONE);
            }
        });

        ImageView imgView = root.findViewById(R.id.imageView);

        Map<String, Integer> nMap = new HashMap<>();

        nMap.put("Hello", 2);
        nMap.put("World", 2);
        nMap.put("Java", 4);
        nMap.put("Digvijay",2);
        nMap.put("Sourabh", 3);
        nMap.put("Pagl",5);
        nMap.put("One", 2);
        nMap.put("Two", 2);
        nMap.put("Three", 4);
        nMap.put("Four",2);
        nMap.put("Five", 3);
        nMap.put("Six",5);
        nMap.put("Seven", 2);
        nMap.put("Eight", 2);
        nMap.put("Nine", 4);
        nMap.put("Ten",2);
        nMap.put("Eleven", 3);
        nMap.put("Fifteen",5);

        WordCloud wd = new WordCloud(nMap, 250, 250,Color.BLUE,Color.WHITE);
        wd.setWordColorOpacityAuto(true);
        wd.setPaddingX(5);
        wd.setPaddingY(5);

        Bitmap generatedWordCloudBmp = wd.generate();

        imgView.setImageBitmap(generatedWordCloudBmp);

        return root;
    }
}