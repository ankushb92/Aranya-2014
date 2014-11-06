package com.limitskyapps.aranya2014;

import com.limitskyapps.aranya2014.Home.MyAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StarNight extends Activity{
	private ListView starlist;
	private StarAdapter starlistAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.starnight_layout);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Shows");

		bar.setDisplayHomeAsUpEnabled(true);


		starlist=(ListView)findViewById(R.id.listView1);
		starlistAdapter=new StarAdapter(this);
		starlist.setAdapter(starlistAdapter);
		
		starlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				if(position==0){
					Intent i=new Intent(StarNight.this,StarPage.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivityForResult(i,0);	
				
				}
				
			}
		});


	}


	private class StarAdapter extends BaseAdapter{

		private Context context;
		int [] images={R.drawable.gmann,R.drawable.lasernight,R.drawable.wheelchair};

		String []name ={"Gurdas Maan","Laser Show","Wheel Chair Dance"};
        String []date={"15 Nov","14 Nov","14 Nov"};		
        String []desig={"Singer/Composer","Show","Show"};
		public StarAdapter(Context c){
			this.context=c;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return name.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return name[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		private int lastPosition = -1;
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View row=null;
			if(convertView==null){
				LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	 

				row=inflator.inflate(R.layout.starnight_inflator,parent,false);


			}
			else{
				row=convertView;	  
			}
			TextView star_name=(TextView)row.findViewById(R.id.star_name);
			TextView dates=(TextView)row.findViewById(R.id.date);
			TextView designation=(TextView)row.findViewById(R.id.Designation);
			TextView Viewinfo=(TextView)row.findViewById(R.id.textView1);
			if((position==1) || (position==2)){
				Viewinfo.setText("");
			    Viewinfo.setBackgroundColor(Color.TRANSPARENT);
			}
			
			
			star_name.setText(name[position]);
			dates.setText(date[position]);
			
			designation.setText(desig[position]);
			RelativeLayout star_image=(RelativeLayout)row.findViewById(R.id.relativeLayout1);
			star_image.setBackgroundResource(images[position]);  

			Animation animation = AnimationUtils.loadAnimation(context , (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
			row.startAnimation(animation);
			lastPosition = position;
			return row;
		}

	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
	}
}
