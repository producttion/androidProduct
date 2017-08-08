package com.example.teerasaksathu.production;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
//
public class Web_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = "https://my-project-1499687014213.firebaseapp.com";
//        WebView webView = (WebView) findViewById(R.id.web_view);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(url);
        CustomTabsIntent webview = new CustomTabsIntent.Builder().build();
        webview.launchUrl(this, Uri.parse(url));


    }






}
