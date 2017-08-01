package com.example.teerasaksathu.production;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    public void btnopenweb(View view) {

        Intent intent = new Intent(getApplicationContext(), Web_view.class);
        startActivity(intent);
    }






}
