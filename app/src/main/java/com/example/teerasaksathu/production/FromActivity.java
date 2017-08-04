package com.example.teerasaksathu.production;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    Spinner spinner2;
    EditText nameEditText;
    EditText surnameEditText;
    EditText telEditText;
    String nameString = "";
    String surnameString = "";
    String telString = "";
    Button buttonbooking;
    EditText[] viewNeedToValidate = {nameEditText, surnameEditText, telEditText};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);


        nameEditText = (EditText) findViewById(R.id.editTextname);
        surnameEditText = (EditText) findViewById(R.id.editTextSurmame);
        telEditText = (EditText) findViewById(R.id.editTextTel);
        connectFireBase = (TextView) findViewById(R.id.textView);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
//        buttonbooking = findViewById(R.id.buttonBooking);

        // ArrayAdapter to Spinner and dropdow

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(FromActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(myAdapter);


        //Connect To Firebase
//        DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
//     final DatabaseReference myDatabaseReference = firebaseDatabase.child("user");

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
    }

    public void conFirmInPutData(View view) {
        int i = 0;
        if (nameEditText.getText().toString().length() == 0) {
            nameEditText.setError("โปรดกรอกข้อมูล");
            i++;
        }
        if (surnameEditText.getText().toString().length() == 0) {
            surnameEditText.setError("โปรดกรอกข้อมูล");
            i++;
        }
        if (telEditText.getText().toString().length() == 0) {
            telEditText.setError("โปรดกรอกข้อมูล");
            i++;
        }
        if (i > 0) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
            builder.setMessage("gg");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();

//            myAlert alert = new myAlert();
//            alert.myDialog(getApplicationContext(), "ผิดพลาด", "โปรดกรอกข้อมูลให้ครบทัุกช่อง");
        } else {
            addDataTofireBase();
            Toast.makeText(getApplicationContext(), "บันทึกข้อมูลเสร็จสิ้น", Toast.LENGTH_LONG).show();
        }

    }


    public void addDataTofireBase() {

        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        telString = telEditText.getText().toString().trim();

        Map<String, Object> vul = new HashMap<String, Object>();

        vul.put("user/" + nameString, addData());
        myRef.updateChildren(vul);
    }


    public addLocktarad addData() {

        addLocktarad addLocktarad = new addLocktarad(nameString, surnameString, telString);
        return addLocktarad;

    }
}





