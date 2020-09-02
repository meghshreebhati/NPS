package com.qdegrees.nps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qdegrees.nps.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNext,btnLogin;
    EditText edtNumber,edtOTP;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.setCancelable(false);

        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        edtNumber = findViewById(R.id.edtNumber);
        edtOTP = findViewById(R.id.edtOTP);

    }

    @Override
    public void onClick(View view) {
        if (view == btnNext) {

            String sNumber = edtNumber.getText().toString();

            if (sNumber.isEmpty()) {
                edtNumber.setError("Fill Mobile Number");
            }else if (sNumber.length() != 10) {
                edtNumber.setError("Fill Valid Number");
            }else if (!sNumber.equals("0000000000")) {
                Toast.makeText(this, "User not Register", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "OTP Send", Toast.LENGTH_SHORT).show();
               sendOTP();
            }
        }

        if (view == btnLogin) {
            String sOTP = edtOTP.getText().toString();

            if (sOTP.isEmpty()) {
                edtOTP.setError("Fill OTP");
            }else if (sOTP.length() != 6) {
                edtOTP.setError("Invalid OTP");
            }else if (!sOTP.equals("000000")) {
                Toast.makeText(this, "OTP not Match", Toast.LENGTH_SHORT).show();
            }else {
                loginUser();
            }

        }

    }

    private void sendOTP() {
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressDialog.dismiss();

                edtNumber.setVisibility(View.GONE);
                edtOTP.setVisibility(View.VISIBLE);

                btnNext.setVisibility(View.GONE);
                btnLogin.setVisibility(View.VISIBLE);
            }
        }, 5000);
    }

    private void loginUser() {

        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
                startActivity(new Intent(LoginActivity.this, Main_MenuActivity.class));
            }
        }, 5000);

    }

}
