package com.qdegrees.nps.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.qdegrees.nps.R;

import java.util.ArrayList;
import java.util.List;

public class TempActivity extends AppCompatActivity {

    // Fill Pie Chart
    private BarChart barChart;
    private PieChart fullPieChart;
    private Typeface tfRegular,tfLight;
    private final String[] parties = new String[] {
            "Speed of Loan Approval","Terms & Conditions not Communicated Clearly"},
            parties1 = {"Payment Reminder","EMI not updated in 3 Days","Issues with payment link",
                    "Reminder after making payment","Payment acknowledgement not received"};
    float valuesChart[] = {15,45},valuesChart1[] = {64,45,64,45,12};
    TextView tvAllDetails;
    CardView cvPieChart,cvBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        setTitle("Loan Approval & Disbrusment");

        tfRegular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        tfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");

        cvPieChart = findViewById(R.id.cvPieChart);
        cvBarChart = findViewById(R.id.cvBarChart);

        tvAllDetails = findViewById(R.id.tvAllDetails);
        tvAllDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("Details");
                cvBarChart.setVisibility(View.VISIBLE);
                cvPieChart.setVisibility(View.GONE);
            }
        });

        // For Bar Chart
        barChart = findViewById(R.id.fullBarChart);

        BarDataSet barDataSet = new BarDataSet(dataValues(),"City 1");
        barDataSet.setColor(Color.BLACK);

        BarDataSet barDataSet1 = new BarDataSet(dataValues1(),"City 2");
        barDataSet.setColor(Color.RED);

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);
        barData.addDataSet(barDataSet1);

        barChart.setData(barData);
        barChart.invalidate();

        // for Pie Chart
        fullPieChart = findViewById(R.id.fullPieChartQuestionWise1);
        fullPieChart.setUsePercentValues(true);
        fullPieChart.getDescription().setEnabled(false);
        fullPieChart.setExtraOffsets(5, 10, 5, 5);

        fullPieChart.setDragDecelerationFrictionCoef(0.95f);

        fullPieChart.setCenterTextTypeface(tfLight);
        //fillPieChart.setCenterText(generateCenterSpannableText());

        fullPieChart.setDrawHoleEnabled(false);
        fullPieChart.setHoleColor(Color.WHITE);

        fullPieChart.setTransparentCircleColor(Color.WHITE);
        fullPieChart.setTransparentCircleAlpha(110);

        fullPieChart.setHoleRadius(58f);
        fullPieChart.setTransparentCircleRadius(61f);

        fullPieChart.setDrawCenterText(true);

        fullPieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        fullPieChart.setRotationEnabled(true);
        fullPieChart.setHighlightPerTapEnabled(true);

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        //chart.setOnChartValueSelectedListener(this);

        fullPieChart.animateY(1400, Easing.EaseInOutQuad);
        //fillPieChart.setPivotX(80f);
        // chart.spin(2000, 0, 360);

        Legend l12 = fullPieChart.getLegend();
        l12.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l12.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l12.setOrientation(Legend.LegendOrientation.VERTICAL);
        l12.setDrawInside(false);
        l12.setXEntrySpace(7f);
        l12.setYEntrySpace(0f);
        l12.setYOffset(10f);
        //l.setXOffset(50f);

        // entry label styling
        fullPieChart.setEntryLabelColor(Color.BLACK);
        fullPieChart.setEntryLabelTypeface(tfRegular);
        fullPieChart.setEntryLabelTextSize(0f);
        //fillPieChart.setMaxAngle(10);

        setData(parties.length, 50);

        fullPieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                int pos1 = e.toString().indexOf("y: ");
                String sTest = e.toString().substring(pos1 + 3);

                for (int u=0; u < valuesChart.length; u ++) {
                    if (valuesChart[u] == Float.valueOf(sTest)) {

                        Intent intent = new Intent(TempActivity.this, PopUpActivity.class);
                        intent.putExtra("value",sTest);
                        intent.putExtra("hideMore","0");
                        startActivity(intent);

                        /*final AlertDialog.Builder mBuilder = new AlertDialog.Builder(TempActivity.this);
                        View mView = LayoutInflater.from(TempActivity.this).inflate(R.layout.chart_details_pop_up,
                                null);
                        mBuilder.setCancelable(false);
                        mBuilder.setView(mView);
                        final AlertDialog dialog = mBuilder.create();
                        TextView tvCloseDialog = mView.findViewById(R.id.tvCancel);

                        tvCloseDialog.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        dialog.setCancelable(true);*/
                    }
                }

                //Toast.makeText(getApplicationContext(), sTest, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        /*// for 2nd Chart
        fillPieChart2 = findViewById(R.id.fullPieChartQuestionWise2);
        fillPieChart2.setUsePercentValues(true);
        fillPieChart2.getDescription().setEnabled(false);
        fillPieChart2.setExtraOffsets(5, 10, 5, 5);

        fillPieChart2.setDragDecelerationFrictionCoef(0.95f);

        fillPieChart2.setCenterTextTypeface(tfLight);
        //fillPieChart.setCenterText(generateCenterSpannableText());

        fillPieChart2.setDrawHoleEnabled(false);
        fillPieChart2.setHoleColor(Color.WHITE);

        fillPieChart2.setTransparentCircleColor(Color.WHITE);
        fillPieChart2.setTransparentCircleAlpha(110);

        fillPieChart2.setHoleRadius(58f);
        fillPieChart2.setTransparentCircleRadius(61f);

        fillPieChart2.setDrawCenterText(true);

        fillPieChart2.setRotationAngle(0);
        // enable rotation of the chart by touch
        fillPieChart2.setRotationEnabled(true);
        fillPieChart2.setHighlightPerTapEnabled(true);

        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);

        // add a selection listener
        //chart.setOnChartValueSelectedListener(this);

        fillPieChart2.animateY(1400, Easing.EaseInOutQuad);
        //fillPieChart.setPivotX(80f);
        // chart.spin(2000, 0, 360);

        Legend l1 = fillPieChart2.getLegend();
        l1.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l1.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l1.setOrientation(Legend.LegendOrientation.VERTICAL);
        l1.setDrawInside(false);
        l1.setXEntrySpace(7f);
        l1.setYEntrySpace(0f);
        l1.setYOffset(10f);
        //l.setXOffset(50f);

        // entry label styling
        fillPieChart2.setEntryLabelColor(Color.BLACK);
        fillPieChart2.setEntryLabelTypeface(tfRegular);
        fillPieChart2.setEntryLabelTextSize(0f);
        //fillPieChart.setMaxAngle(10);
        setData2(parties1.length, 50);*/

    }

    private ArrayList<BarEntry> dataValues() {
        ArrayList<BarEntry> dataValue = new ArrayList<BarEntry>();
        dataValue.add(new BarEntry(0,3));
        dataValue.add(new BarEntry(1,4));
        dataValue.add(new BarEntry(3,6));
        dataValue.add(new BarEntry(4,10));

        return  dataValue;
    }

    private ArrayList<BarEntry> dataValues1() {
        ArrayList<BarEntry> dataValue = new ArrayList<BarEntry>();
        dataValue.add(new BarEntry(5,0));
        dataValue.add(new BarEntry(2,1));
        dataValue.add(new BarEntry(7,3));
        dataValue.add(new BarEntry(4,2));

        return  dataValue;
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
        data.setValueFormatter(new PercentFormatter(fullPieChart));
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(tfLight);
        fullPieChart.setData(data);

        // undo all highlights
        fullPieChart.highlightValues(null);

        fullPieChart.invalidate();
    }


    /*private void setData2(int count, float range) {
        ArrayList<PieEntry> entries = new ArrayList<>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count ; i++) {
            entries.add(new PieEntry((valuesChart1[i]), parties1[i % parties1.length],
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
        data.setValueFormatter(new PercentFormatter(fillPieChart2));
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(tfLight);
        fillPieChart2.setData(data);

        // undo all highlights
        fillPieChart2.highlightValues(null);

        fillPieChart2.invalidate();
    }*/

}
