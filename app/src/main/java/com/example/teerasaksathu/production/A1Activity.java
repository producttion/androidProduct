package com.example.teerasaksathu.production;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class A1Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnA7, btnA8, btnA9, btnA10, btnA11, btnA12, btnA13, btnA14, btnA15, btnA16, btnA17;
    Button btnA18, btnA19, btnA20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        btnA1 = (Button) findViewById(R.id.btn1);
        btnA2 = (Button) findViewById(R.id.btn2);
        btnA3 = (Button) findViewById(R.id.btn3);
        btnA4 = (Button) findViewById(R.id.btn4);
        btnA5 = (Button) findViewById(R.id.btn5);
        btnA6 = (Button) findViewById(R.id.btn6);
        btnA7 = (Button) findViewById(R.id.btn7);
        btnA8 = (Button) findViewById(R.id.btn8);
        btnA9 = (Button) findViewById(R.id.btn9);
        btnA10 = (Button) findViewById(R.id.btn10);
        btnA11 = (Button) findViewById(R.id.btn11);
        btnA12 = (Button) findViewById(R.id.btn12);
        btnA13 = (Button) findViewById(R.id.btn13);
        btnA14 = (Button) findViewById(R.id.btn14);
        btnA15 = (Button) findViewById(R.id.btn15);
        btnA16 = (Button) findViewById(R.id.btn16);
        btnA17 = (Button) findViewById(R.id.btn17);
        btnA18 = (Button) findViewById(R.id.btn18);
        btnA19 = (Button) findViewById(R.id.btn19);
        btnA20 = (Button) findViewById(R.id.btn20);


        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);
        btnA3.setOnClickListener(this);
        btnA4.setOnClickListener(this);
        btnA5.setOnClickListener(this);
        btnA6.setOnClickListener(this);
        btnA7.setOnClickListener(this);
        btnA8.setOnClickListener(this);
        btnA9.setOnClickListener(this);
        btnA10.setOnClickListener(this);
        btnA11.setOnClickListener(this);
        btnA12.setOnClickListener(this);
        btnA13.setOnClickListener(this);
        btnA14.setOnClickListener(this);
        btnA15.setOnClickListener(this);
        btnA16.setOnClickListener(this);
        btnA17.setOnClickListener(this);
        btnA18.setOnClickListener(this);
        btnA19.setOnClickListener(this);
        btnA20.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == btnA1) {
            lockChecking("A1", false);
        }
        if (view == btnA2) {
            lockChecking("A2", false);

        }
        if (view == btnA3) {
            lockChecking("A3", false);

        }
        if (view == btnA4) {
            lockChecking("A4", false);

        }
        if (view == btnA5) {
            lockChecking("A5", false);

        }
        if (view == btnA6) {
            lockChecking("A6", false);

        }
        if (view == btnA7) {
            lockChecking("A7", false);

        }
        if (view == btnA8) {
            lockChecking("A8", false);

        }
        if (view == btnA9) {
            lockChecking("A9", false);

        }
        if (view == btnA10) {
            lockChecking("A10", false);

        }
        if (view == btnA11) {
            lockChecking("A11", false);

        }
        if (view == btnA12) {
            lockChecking("A12", false);

        }
        if (view == btnA13) {
            lockChecking("A13", true);

        }
        if (view == btnA14) {
            lockChecking("A14", true);

        }
        if (view == btnA15) {

            lockChecking("A15", true);
        }
        if (view == btnA16) {
            lockChecking("A16", true);

        }
        if (view == btnA17) {
            lockChecking("A17", true);

        }
        if (view == btnA18) {
            lockChecking("A18", true);

        }
        if (view == btnA19) {
            lockChecking("A19", true);

        }
        if (view == btnA20) {
            lockChecking("A20", true);

        }

    }

    public void lockChecking(String lockID, boolean lockStatus) {

        if (lockStatus) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(getApplicationContext(), "รายละเอียดล็อค "+lockID,"fdsferfd","cvfdv","ewwqwe1231","1232131");

        } else {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            intent.putExtra("lockID", lockID);
            startActivity(intent);
        }
    }

}
