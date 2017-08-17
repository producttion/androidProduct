package com.example.teerasaksathu.production;

import android.content.Context;
import  android.app.AlertDialog;
import android.content.DialogInterface;



public class MyAlert {

    public void myDialog(Context context,String title,String name,String tel,String surname,String productType) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(name + surname +tel+ productType);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

}//main clls
