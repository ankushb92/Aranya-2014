package com.limitskyapps.aranya2014;

import com.limitskyapps.aranya2014.Home.MyAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Settings extends Activity{
	int flag=1;
	int finishflag=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_settings);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Settings");

		bar.setDisplayHomeAsUpEnabled(true);
       final ImageView notif_btn=(ImageView)findViewById(R.id.notif);
       TableRow likeOnFB=(TableRow)findViewById(R.id.likeonfb);
       TableRow notif=(TableRow)findViewById(R.id.tableRow1);
       
       notif.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(flag==0){
				notif_btn.setImageResource(R.drawable.notifon);	
					flag=1;
				}
				else
					if(flag==1){
						notif_btn.setImageResource(R.drawable.notifoff);	
							flag=0;
						}
		}
	});
       
       likeOnFB.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{		 Intent browserIntent = 
					new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Limitsky-Apps/598335670239526"));
			finishflag=0;
			startActivity(browserIntent);		

			}catch( Exception e)
			{
				e.printStackTrace();
			}
		}
			
		
	});
       
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(finishflag==1){
			finish();
		//finish();
	}}
}

