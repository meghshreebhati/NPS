package com.qdegrees.nps.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.FileUtils;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.qdegrees.nps.DemoBase;
import com.qdegrees.nps.R;
import com.qdegrees.nps.activity.Main_MenuActivity;
import com.qdegrees.nps.adapter.PageAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    // for spinner
    Spinner spinChannel,spinJourney,spinTouchPoint,spinDateRange;

    // for tabLayout
    private TabLayout tabLayout;
    private ViewPager viewPager;
    protected PageAdapter pageAdapter;
    protected TabItem tabTitle1,tabTitle2,tabTitle3,tabTitle4,tabTitle5,tabTitle6;

    // for teb view all textView
    private TextView tvTitle1,tvTitle2,tvTitle3,tvTitle4,tvTitle5;
    private LinearLayout linearLayoutTitle1,linearLayoutTitle2,linearLayoutTitle3;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        /*

        getActivity().setTitle("Home");

        */
        /*spinChannel = root.findViewById(R.id.spinChannel);
        String[] saChannel = {"All","Email","SMS","Web-Form"};
        ArrayAdapter<String> channelAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, saChannel);
        spinChannel.setAdapter(channelAdapter);

        spinJourney = root.findViewById(R.id.spinJourney);
        String[] saJouney = {"All","DMI CSR","EMI Payment","DMI Onboarding"};
        ArrayAdapter<String> journeyAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, saJouney);
        spinJourney.setAdapter(journeyAdapter);

        spinTouchPoint = root.findViewById(R.id.spinTouchPoint);
        String[] saTouchPoint = {"All","Credright","MobiKwik","Money Tap"};
        ArrayAdapter<String> touchPointAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, saTouchPoint);
        spinTouchPoint.setAdapter(touchPointAdapter);

        spinDateRange = root.findViewById(R.id.spinDateRange);
        String[] saDateRange = {"Select Date Range","Today","Yesterday","Last 7days"};
        ArrayAdapter<String> dateRangeAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, saDateRange);
        spinDateRange.setAdapter(dateRangeAdapter);*//*

        linearLayoutTitle1 = root.findViewById(R.id.linearLayoutTitle1);
        linearLayoutTitle1.setVisibility(View.VISIBLE);

        linearLayoutTitle2 = root.findViewById(R.id.linearLayoutTitle2);
        linearLayoutTitle3 = root.findViewById(R.id.linearLayoutTitle3);

        tvTitle1 = root.findViewById(R.id.tvTitle1);
        tvTitle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutTitle1.setVisibility(View.VISIBLE);
                linearLayoutTitle2.setVisibility(View.GONE);
                linearLayoutTitle3.setVisibility(View.GONE);

                tvTitle1.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTitle1.setBackgroundColor(getResources().getColor(R.color.myWhite));

                tvTitle2.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle3.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle4.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle5.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle5.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        tvTitle2 = root.findViewById(R.id.tvTitle2);
        tvTitle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutTitle1.setVisibility(View.GONE);
                linearLayoutTitle2.setVisibility(View.VISIBLE);
                linearLayoutTitle3.setVisibility(View.GONE);

                tvTitle2.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTitle2.setBackgroundColor(getResources().getColor(R.color.myWhite));

                tvTitle1.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle3.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle4.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle5.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle5.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        tvTitle3 = root.findViewById(R.id.tvTitle3);
        tvTitle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutTitle1.setVisibility(View.GONE);
                linearLayoutTitle2.setVisibility(View.GONE);
                linearLayoutTitle3.setVisibility(View.VISIBLE);

                tvTitle3.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTitle3.setBackgroundColor(getResources().getColor(R.color.myWhite));

                tvTitle2.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle1.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle4.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle5.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle5.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        tvTitle4 = root.findViewById(R.id.tvTitle4);
        tvTitle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutTitle1.setVisibility(View.GONE);
                linearLayoutTitle2.setVisibility(View.GONE);
                linearLayoutTitle3.setVisibility(View.GONE);

                tvTitle4.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTitle4.setBackgroundColor(getResources().getColor(R.color.myWhite));

                tvTitle2.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle3.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle1.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle5.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle5.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        tvTitle5 = root.findViewById(R.id.tvTitle5);
        tvTitle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linearLayoutTitle1.setVisibility(View.GONE);
                linearLayoutTitle2.setVisibility(View.GONE);
                linearLayoutTitle3.setVisibility(View.GONE);

                tvTitle5.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvTitle5.setBackgroundColor(getResources().getColor(R.color.myWhite));

                tvTitle2.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle3.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle4.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                tvTitle1.setTextColor(getResources().getColor(R.color.myWhite));
                tvTitle1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });*/

        // for tabview
        tabLayout = root.findViewById(R.id.tabLayout);
        viewPager = root.findViewById(R.id.viewPager);

        tabTitle1 = root.findViewById(R.id.tbTitle1);
        tabTitle2 = root.findViewById(R.id.tbTitle2);
        tabTitle3 = root.findViewById(R.id.tbTitle3);
        tabTitle4 = root.findViewById(R.id.tbTitle4);
        tabTitle5 = root.findViewById(R.id.tbTitle5);
        tabTitle6 = root.findViewById(R.id.tbTitle6);

        pageAdapter = new PageAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        //viewPager.setCurrentItem(0);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 1) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.colorPrimary));
                }else if (tab.getPosition() == 2) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.colorPrimary));
                }else if (tab.getPosition() == 3) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.colorPrimary));
                }else if (tab.getPosition() == 4) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.colorPrimary));
                }else if (tab.getPosition() == 5) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.colorPrimary));
                } else {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(root.getContext(),R.color.colorPrimary));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return root;
    }

}