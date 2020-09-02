package com.qdegrees.nps.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.qdegrees.nps.R;
import com.qdegrees.nps.activity.PopUpActivity;
import com.qdegrees.nps.activity.TempActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TabTitle3Fragment extends Fragment {

    Spinner spinDateFilter;

    // Fill Pie Chart
    private PieChart fillPieChart;
    private Typeface tfRegular,tfLight;
    private final String[] parties = new String[] {
            "Loan Approval","Interaction with Organisation"
            ,"EMI Experience","Others"};
    private float valuesChart[] = {15,45,30,30};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_tab_title3, container, false);

        spinDateFilter = root.findViewById(R.id.spinDateFilter2);
        String[] dateFilter = {"Today","Yesterday","Last Week","Last Month","Last Year"};
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, dateFilter);
        spinDateFilter.setAdapter(dateAdapter);

        tfRegular = Typeface.createFromAsset(root.getContext().getAssets(), "OpenSans-Regular.ttf");
        tfLight = Typeface.createFromAsset(root.getContext().getAssets(), "OpenSans-Light.ttf");

        fillPieChart = root.findViewById(R.id.fullPieChartQuestionWise);
        fillPieChart.setUsePercentValues(true);
        fillPieChart.getDescription().setEnabled(false);
        fillPieChart.setExtraOffsets(5, 10, 5, 5);

        fillPieChart.setDragDecelerationFrictionCoef(0.95f);

        fillPieChart.setCenterTextTypeface(tfLight);
        //fillPieChart.setCenterText(generateCenterSpannableText());

        fillPieChart.setDrawHoleEnabled(false);
        fillPieChart.setHoleColor(Color.WHITE);

        fillPieChart.setTransparentCircleColor(Color.WHITE);
        fillPieChart.setTransparentCircleAlpha(110);

        fillPieChart.setHoleRadius(58f);
        fillPieChart.setTransparentCircleRadius(61f);

        fillPieChart.setDrawCenterText(true);

        fillPieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        fillPieChart.setRotationEnabled(true);
        fillPieChart.setHighlightPerTapEnabled(true);

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        //chart.setOnChartValueSelectedListener(this);

        fillPieChart.animateY(1400, Easing.EaseInOutQuad);
        //fillPieChart.setPivotX(80f);
        // chart.spin(2000, 0, 360);

        Legend l = fillPieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(10f);
        //l.setXOffset(50f);

        // entry label styling
        fillPieChart.setEntryLabelColor(Color.BLACK);
        fillPieChart.setEntryLabelTypeface(tfRegular);
        fillPieChart.setEntryLabelTextSize(0f);
        //fillPieChart.setMaxAngle(10);

        setData(parties.length, 50);

        fillPieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                int pos1 = e.toString().indexOf("y: ");
                String sTest = e.toString().substring(pos1 + 3);

                if (valuesChart[0] == Float.valueOf(sTest)) {

                    Intent intent = new Intent(getContext(), PopUpActivity.class);
                    intent.putExtra("value",sTest);
                    intent.putExtra("hideMore","1");
                    //intent.putExtra("percentage","");
                    startActivity(intent);

                }

                //Toast.makeText(getApplicationContext(), sTest, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        return root;
    }

    private void setData(int count, float range) {
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count ; i++) {
            entries.add(new PieEntry((valuesChart[i]), parties[i % parties.length],
                    getResources().getDrawable(R.drawable.star)));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(fillPieChart));
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(tfLight);
        fillPieChart.setData(data);

        // undo all highlights
        fillPieChart.highlightValues(null);

        fillPieChart.invalidate();
    }


}