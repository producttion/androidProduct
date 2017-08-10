package com.example.teerasaksathu.production;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnA1;
    Button btnA2;
    TextView textView;
    String lockID;
    boolean lockStatus;

    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA1 = (Button) findViewById(R.id.btnA1);
        btnA2 = (Button) findViewById(R.id.btnA2);
        textView = (TextView) findViewById(R.id.textView);


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();




        myRef.child("lock").child("id").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                lockID = String.valueOf(map.get("lockid"));
                lockStatus = (boolean) map.get("status");
                textView.setText(btnA1.getResources().getResourceName(btnA1.getId()));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        btnA1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == btnA1 && lockStatus){
            if (lockStatus) {
                    Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                    intent.putExtra("lockID", lockID);
                    startActivity(intent);
//                textView.setText("Go to information page");
            } else {
                textView.setText("Go to register page");
            }
        } else if (view == btnA2) {
            if (lockStatus) {
//                    Intent intent = new Intent(getApplicationContext(), FormActivity.class);
//                    intent.putExtra("lockID", lockID);
//                    startActivity(intent);
                textView.setText("Go to information page");
            } else {
                textView.setText("Go to register page");
            }

        }
    }
}
