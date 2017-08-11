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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);


        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();






    }
    @Override
    public void onClick(View view) {
        if (view == btnA1) {
            lockChecking("A1");
        } else if (view == btnA2) {
            lockChecking("A2");
        }
    }

    private void lockChecking(String id) {
        myRef.child("lock").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();

                lockID = String.valueOf(map.get("lockID"));
                lockStatus = (boolean) map.get("status");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        if (lockStatus) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(MainActivity.this,"รายละเอียดการจอง", lockID);
        } else {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            intent.putExtra("lockID",lockID);
            startActivity(intent);
        }
    }


}
