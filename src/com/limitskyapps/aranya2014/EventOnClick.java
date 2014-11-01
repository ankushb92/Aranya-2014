package com.limitskyapps.aranya2014;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

;

public class EventOnClick extends Activity{
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
		setContentView(R.layout.eventsonclick_layout);
	ActionBar bar = getActionBar();
	bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
	bar.setTitle("Events");

	bar.setDisplayHomeAsUpEnabled(true);

	WebView wv1=(WebView)findViewById(R.id.webView1);
	//wv1.getSettings().setLoadWithOverviewMode(true);
	//wv1.getSettings().setUseWideViewPort(true);
	
	wv1.loadUrl("file:///android_asset/hoveron.html");
}

}