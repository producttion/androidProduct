package com.example.teerasaksathu.production;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etSurname;
    EditText etPhonenumber;
    CheckBox cbReservationCancel;
    Button btnConfirm;
    Button btnCancel;
    Spinner spProductType;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        initInstances();

        //Connect to firebase
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

    private void initInstances() {
        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etPhonenumber = (EditText) findViewById(R.id.etPhonenumber);
        cbReservationCancel = (CheckBox) findViewById(R.id.cbCancelReservation);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        spProductType = (Spinner) findViewById(R.id.spProductType);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProductType.setAdapter(myAdapter);

        btnConfirm.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnConfirm) {
            if (cbReservationCancel.isChecked()) {
                Toast.makeText(getApplicationContext(), "ยกเลิกการจองเเสร็จสิ้น", Toast.LENGTH_LONG).show();
            } else {
                if (checkData()) {
                    addDataTofireBase();
                    Toast.makeText(getApplicationContext(), "บันทึกข้อมูลเสร็จสิ้น", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getApplicationContext(), "โปรดกรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_LONG).show();
            }
        } else if (view == btnCancel) {

        }
    }

    private void addDataTofireBase() {
        String name = etName.getText().toString().trim();
        String surname = etSurname.getText().toString().trim();
        String phonenumber = etPhonenumber.getText().toString().trim();
        String productType = spProductType.getSelectedItem().toString();
        Locktalad locktalad = new Locktalad(name, surname, phonenumber, productType);

        Map<String, Object> vul = new HashMap<String, Object>();

        vul.put("user/" + name, locktalad);
        myRef.updateChildren(vul);
    }


    private boolean checkData() {
        int numberOfError = 0;
        if (etName.getText().toString().length() == 0) {
            etName.setError("Input something");
            numberOfError++;
        }
        if (etSurname.getText().toString().length() == 0) {
            etSurname.setError("Input something");
            numberOfError++;
        }
        if (etPhonenumber.getText().toString().length() == 0) {
            etPhonenumber.setError("Input something");
            numberOfError++;
        }

        if (numberOfError > 0)
            return false;
        else
            return true;
    }
}





