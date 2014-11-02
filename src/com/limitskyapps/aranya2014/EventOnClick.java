package com.limitskyapps.aranya2014;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;


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
	
	Bundle bundle = this.getIntent().getExtras();
	int position = bundle.getInt("position");
	
	if(position==0)
		wv1.loadUrl("file:///android_asset/hoveron.html");
	else if(position==1)
		wv1.loadUrl("file:///android_asset/inclino.html");
	else if(position==2)
		wv1.loadUrl("file:///android_asset/waterrocket.html");
	else if(position==3)
		wv1.loadUrl("file:///android_asset/minedetector.html");
	else if(position==4)
		wv1.loadUrl("file:///android_asset/ideate.html");
	else if(position==5)
		wv1.loadUrl("file:///android_asset/arjun.html");
	else if(position==6)
		wv1.loadUrl("file:///android_asset/chemicanon.html");
	else if(position==7)
		wv1.loadUrl("file:///android_asset/tabletennis.html");
	else if(position==8)
		wv1.loadUrl("file:///android_asset/badminton.html");
	else if(position==9)
		wv1.loadUrl("file:///android_asset/lawntennis.html");
	else if(position==10)
		wv1.loadUrl("file:///android_asset/codegolf.html");
	else if(position==11)
		wv1.loadUrl("file:///android_asset/openthelock.html");
	else if(position==12)
		wv1.loadUrl("file:///android_asset/windthrust.html");
	else if(position==13)
		wv1.loadUrl("file:///android_asset/trussbridge.html");
	else if(position==14)
		wv1.loadUrl("file:///android_asset/contraption.html");
	else if(position==15)
		wv1.loadUrl("file:///android_asset/crystalclear.html");
	else if(position==16)
		wv1.loadUrl("file:///android_asset/caughtred.html");
	else if(position==17)
		wv1.loadUrl("file:///android_asset/decipher.html");
	else if(position==18)
		wv1.loadUrl("file:///android_asset/circuittrash.html");
}

}