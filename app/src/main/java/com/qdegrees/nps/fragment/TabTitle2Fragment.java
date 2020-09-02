package com.qdegrees.nps.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.FileUtils;
import com.qdegrees.nps.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TabTitle2Fragment extends Fragment {

    // for bar chart
    private BarChart barChart;
    private List<BarEntry> barChartData;
    // for font of chart
    private Typeface tfRegular,tfLight;

    private Spinner spinDateFilter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tab_title2, container, false);

        spinDateFilter = root.findViewById(R.id.spinDateFilter1);
        String[] dateFilter = {"Today","Yesterday","Last Week","Last Month","Last Year"};
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, dateFilter);
        spinDateFilter.setAdapter(dateAdapter);

        tfRegular = Typeface.createFromAsset(root.getContext().getAssets(), "OpenSans-Regular.ttf");
        tfLight = Typeface.createFromAsset(root.getContext().getAssets(), "OpenSans-Light.ttf");

        barChart = root.findViewById(R.id.barChart);

        forBarChart(root.getContext());

        return root;
    }

    private void forBarChart(Context mCtx) {

        barChartData = FileUtils.loadBarEntriesFromAssets(mCtx.getAssets(), "othersine.txt");

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);

        barChart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        barChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        barChart.setPinchZoom(false);

        // draw shadows for each bar that show the maximum value
        // chart.setDrawBarShadow(true);

        // chart.setDrawXLabels(false);

        barChart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setTypeface(tfLight);
        leftAxis.setLabelCount(6, false);
        leftAxis.setAxisMinimum(-2.5f);
        leftAxis.setAxisMaximum(2.5f);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setGranularity(0.1f);

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setTypeface(tfLight);
        rightAxis.setLabelCount(6, false);
        rightAxis.setAxisMinimum(-2.5f);
        rightAxis.setAxisMaximum(2.5f);
        rightAxis.setGranularity(0.1f);


        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        barChart.animateXY(1500, 1500);

        setBarChartData();

    }

    private void setBarChartData() {

        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int i = 0; i < barChartData.size(); i++) {
            entries.add(barChartData.get(i));
        }

        BarDataSet set;

        if (barChart.getData() != null &&
                barChart.getData().getDataSetCount() > 0) {
            set = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            set.setValues(entries);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set = new BarDataSet(entries, "Sinus Function");
            set.setColor(Color.rgb(240, 120, 124));
        }

        BarData data = new BarData(set);
        data.setValueTextSize(10f);
        data.setValueTypeface(tfLight);
        data.setDrawValues(false);
        data.setBarWidth(0.8f);

        barChart.setData(data);
    }

}