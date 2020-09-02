package com.qdegrees.nps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.qdegrees.nps.R;

public class PopUpActivity extends AppCompatActivity implements View.OnClickListener{


    TextView tvCancelActivity,tvMoreChart,tvValue1;
    String sValue,sHideValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        getSupportActionBar().hide();

        sValue = getIntent().getStringExtra("value");
        sHideValue = getIntent().getStringExtra("hideMore");

        tvValue1 = findViewById(R.id.tvValue1);
        tvValue1.setText("Value: " + sValue);

        tvMoreChart = findViewById(R.id.tvMoreChart);
        tvMoreChart.setOnClickListener(this);

        tvCancelActivity = findViewById(R.id.tvCancelActivity);
        tvCancelActivity.setOnClickListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int width = dm.widthPixels;
        int height = dm.widthPixels;

        getWindow().setLayout((int)(width*.4),(int)(height*.3));

        if (sHideValue.equals("0")) {
            tvMoreChart.setVisibility(View.GONE);
            getWindow().setLayout((int)(width*.4),(int)(height*.2));
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {

        if (view == tvMoreChart) {
            startActivity(new Intent(PopUpActivity.this, TempActivity.class));
        }

        if (view == tvCancelActivity) {
            onBackPressed();
        }

    }
}
