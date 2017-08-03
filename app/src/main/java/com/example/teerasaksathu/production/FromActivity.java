package com.example.teerasaksathu.production;

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


    EditText nameEditText,
            surnameEditText,
            telEditText;
    String nameString = "",
            surnameString = "",
            telString = "";
    Button buttonbooking;


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

    public void conFirmInPutDat(View view) {

        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        telString = telEditText.getText().toString().trim();

        connectFireBase.setText(nameString);


        if (nameString == "1") {

            myAlert myAlert = new myAlert();
            myAlert.myDialog(getApplicationContext(), "มีช่องว่าง", "กรุณากรอกให้ครับ");

        } else {
            addDataTofireBase();
            Toast.makeText(getApplicationContext(), "ตกลง", Toast.LENGTH_LONG).show();

        }

    }


    public void addDataTofireBase() {

        Map<String, Object> vul = new HashMap<String, Object>();

        vul.put("user/" + nameString, addData());
        myRef.updateChildren(vul);
    }


    public addLocktarad addData() {

        addLocktarad addLocktarad = new addLocktarad(nameString, surnameString, telString);
        return addLocktarad;

    }

}

class addLocktarad {
    String nameString, surnameString, telString;

    public addLocktarad() {
        nameString = "none";
        surnameString = "none";
        telString = "none";
    }

    public addLocktarad(String nameString, String surnameString, String telString) {
        this.nameString = nameString;
        this.surnameString = surnameString;
        this.telString = telString;

    }

    public String getNameString() {
        return nameString;
    }

    public String getSurnameString() {
        return surnameString;
    }

    public String getTelString() {
        return telString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public void setSurnameString(String surnameString) {
        this.surnameString = surnameString;
    }

    public void setTelString(String telString) {
        this.telString = telString;
    }





}



