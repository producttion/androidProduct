package com.example.teerasaksathu.production;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn20Button;
    Boolean



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn20Button = (Button) findViewById(R.id.button20);

        btn20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FormActivity.class);
                intent.putExtra("lockid",);
                startActivity(intent);
            }
        });








    }
}
