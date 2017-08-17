package com.example.teerasaksathu.production;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnA1,btnA2,btnA3,btnA4,btnA5,btnA6,btnA7,btnA8,btnA9,btnA10,btnA11,btnA12,btnA13,btnA14,btnA15,btnA16,btnA17;
   Button btnA18,btnA19,btnA20,btnA21;
    String lockID;
    boolean lockStatus;
//    DatabaseReference myRef;
//    String lockta = "A1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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





//
// FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        myRef = firebaseDatabase.getReference();
//
//
//        myRef.child("lock").addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Map map = (Map) dataSnapshot.getValue();
//
//                lockID = String.valueOf(map.get("lockid"));
//                lockStatus = (boolean) map.get("status");
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
//
//

    }

    public void getDataIntent() {
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String surname = bundle.getString("surname");
        String telUser = bundle.getString("phonenumber");
        String productType = bundle.getString("productType");

        Log.v("data Intent :", name);
        Log.v("data Intent :", surname);
        Log.v("data Intent :", telUser);
        Log.v("data Intent :", productType);
    }


    public void lockChecking() {

        if (lockStatus) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(MainActivity.this,"รายละเอียดการจอง", lockID);

        } else {
            Intent intent = new Intent(getApplicationContext(), FormActivity.class);
            intent.putExtra("lockID",lockID);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View view) {
        if (view == btnA1) {
            lockChecking();
        } if (view == btnA2) {
            lockChecking();

        } if (view == btnA3) {
            lockChecking();

        }
        if (view == btnA4) {
            lockChecking();

        }
        if (view == btnA5) {
            lockChecking();

        }
        if (view == btnA6) {
            lockChecking();

        }
        if (view == btnA7) {
            lockChecking();

        }
        if (view == btnA8) {
            lockChecking();

        }
        if (view == btnA9) {
            lockChecking();

        }
        if (view == btnA10) {
            lockChecking();

        }
        if (view == btnA11) {
            lockChecking();

        }
        if (view == btnA12) {
            lockChecking();

        }
        if (view == btnA13) {
            lockChecking();

        }
        if (view == btnA14) {
            lockChecking();

        }
        if (view == btnA15) {

            lockChecking();
        }
        if (view == btnA16) {
            lockChecking();

        }
        if (view == btnA17) {
            lockChecking();

        }
        if (view == btnA18) {
            lockChecking();

        }
        if (view == btnA19) {
            lockChecking();

        }
        if (view == btnA20) {
            lockChecking();

        }

    }
}
