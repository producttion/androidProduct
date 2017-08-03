package com.example.teerasaksathu.production;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class FromActivity extends AppCompatActivity {

    public DatabaseReference myRef;
    TextView connectFireBase;
    Button addVule;

    EditText nameEditText,
            surnameEditText,
            telEditText;
    String nameString,
            surnameString,
            telString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        nameEditText = (EditText) findViewById(R.id.editTextname);
        surnameEditText = (EditText) findViewById(R.id.editTextSurmame);
        telEditText = (EditText) findViewById(R.id.editTextTel);
        connectFireBase = (TextView) findViewById(R.id.textView);
        addVule = (Button) findViewById(R.id.buttonBooking);


        //Connect To Firebase
//        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
//        final DatabaseReference myDatabaseReference = firebaseDatabase.child("user");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();


//        addVule.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myDatabaseReference.setValue("lhg;n,m");
//            }
//        });



//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Map map = (Map) dataSnapshot.getValue();
//                String vul = String.valueOf(map.get("user"));
//                connectFireBase.setText(vul);
//
////                Toast.makeText(getApplicationContext(),vul,Toast.LENGTH_LONG).show();
//
//
//                //เหลือรอหน้าเสร็จ เพื่อเช็ค ว่างหรือ ไม่ กรอกครบ ไหม ตัวเลขเหลือป่าว
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
   }

    public void conFirmInPutDat(View view) {

        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        telString = telEditText.getText().toString().trim();


        if (nameString == "" || surnameString =="" || telString== "") {

            myAlert myAlert = new myAlert();
            myAlert.myDialog(getApplicationContext(),"มีช่องว่าง","กรุณากรอกให้ครับ");

        }else {
            addDataTofireBase();
            Toast.makeText(getApplicationContext(), "ตกลง", Toast.LENGTH_LONG).show();

        }

    }


    public void addDataTofireBase() {





        Map<String, Object> vul =new HashMap<String, Object>();

        vul.put("user/"+nameString, nameString);


//        myRef.updateChildren(vul);
        myRef.push();
//


    }

    }




