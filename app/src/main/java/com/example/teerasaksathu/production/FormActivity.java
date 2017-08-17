package com.example.teerasaksathu.production;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



import com.google.firebase.database.DatabaseReference;


import java.util.HashMap;
import java.util.Map;

public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etSurname;
    EditText etPhonenumber;
    TextView tvHeader;
    Button btnConfirm;
    Button btnCancel;
    Spinner spProductType;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        initInstances();
        String getlock;


//        Bundle bundle = getIntent().getExtras();
//        getlock = bundle.getString("lockID");
//        if (bundle != null) {
//           tvHeader.setText("รายละเอียดล็อค " + getlock);
//        }
    }

    private void initInstances() {

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etPhonenumber = (EditText) findViewById(R.id.etPhonenumber);
        //      cbReservationCancel = (CheckBox) findViewById(R.id.cbCancelReservation);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        spProductType = (Spinner) findViewById(R.id.spProductType);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(FormActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProductType.setAdapter(myAdapter);
        tvHeader = (TextView) findViewById(R.id.tvHeader);

        btnConfirm.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == btnConfirm) {
            if (checkData()) {
                addDataTofireBase();
                Toast.makeText(getApplicationContext(), "บันทึกข้อมูลเสร็จสิ้น", Toast.LENGTH_LONG).show();
            } else
                Toast.makeText(getApplicationContext(), "โปรดกรอกข้อมูลให้ครบทุกช่อง", Toast.LENGTH_LONG).show();

        } else if (view == btnCancel) {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
    private void addDataTofireBase() {
        String name = etName.getText().toString().trim();
        String surname = etSurname.getText().toString().trim();
        String phonenumber = etPhonenumber.getText().toString().trim();
        String productType = spProductType.getSelectedItem().toString();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("surname", surname);
        intent.putExtra("phonenumber", phonenumber);
        intent.putExtra("productType", productType);
        startActivity(intent);



//        Locktalad locktalad = new Locktalad(name, surname, phonenumber, productType);
//        Map<String, Object> vul = new HashMap<String, Object>();
//
//        vul.put("user/" + name, locktalad);
//        myRef.updateChildren(vul);
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





