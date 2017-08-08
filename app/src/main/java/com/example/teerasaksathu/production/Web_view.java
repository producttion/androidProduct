package com.example.teerasaksathu.production;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

//
public class Web_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = "https://my-project-1499687014213.firebaseapp.com";
        WebView webView = (WebView) findViewById(R.id.wed_view);
        Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(intent);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);


    }






}
