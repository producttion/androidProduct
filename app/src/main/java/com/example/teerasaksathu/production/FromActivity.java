package com.example.teerasaksathu.production;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import static com.example.teerasaksathu.production.R.id.ButtonBooking;
import static com.example.teerasaksathu.production.R.id.button;

public class FromActivity extends AppCompatActivity {

    public DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String vul = String.valueOf(map.get("test"));

                //เหลือรอหน้าเสร็จ เพื่อเช็ค ว่างหรือ ไม่ กรอกครบ ไหม ตัวเลขเหลือป่าว
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }





        });


        final Button button = (Button) findViewById(R.id.ButtonBooking);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ButtonBooking);

            }
        });





    }

}
