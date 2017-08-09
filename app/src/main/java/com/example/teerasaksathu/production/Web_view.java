package com.example.teerasaksathu.production;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//
public class Web_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        // String url = "https://my-project-1499687014213.firebaseapp.com";
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("https://my-project-1499687014213.firebaseapp.com");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


    }




}

