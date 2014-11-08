package com.limitskyapps.aranya2014;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.w3c.dom.Text;

import com.limitskyapps.aranya2014.SplashScreen.PlaceholderFragment;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.*;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class HomeTest2 extends ActionBarActivity implements OnItemClickListener {

	// intializing the drawer layout and listview
	private DrawerLayout drawerLayout;
	private ListView listview;
	private String[] items;// intializing the array
	private ActionBarDrawerToggle drawerlistener;
	private MyAdapter myAdapter;
	ImageView navigation_image, fb, yt;
	ImageView events_btn, starnight_btn, sponsors, schedule_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the layout
		setContentView(R.layout.new_homelayout);

		// customize the actionbar
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Home");

		// find the views in the layout.
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		listview = (ListView) findViewById(R.id.left_drawer);
		myAdapter = new MyAdapter(this);
		items = getResources().getStringArray(R.array.items);
		final RelativeLayout imgslider = (RelativeLayout) findViewById(R.id.imgslide);
		final ImageView sldimg = (ImageView) findViewById(R.id.slide);
		events_btn = (ImageView) findViewById(R.id.ev);
		starnight_btn = (ImageView) findViewById(R.id.sn);
		sponsors = (ImageView) findViewById(R.id.sp);
		schedule_btn = (ImageView) findViewById(R.id.sc);
		fb = (ImageView) findViewById(R.id.fb);
		yt = (ImageView) findViewById(R.id.yt);
		ViewFlipper vf = (ViewFlipper) findViewById(R.id.viewflipper);

		/*
		 * int x=0; while(x<100){ Animation animation1=new
		 * TranslateAnimation(0.0f,2000f, 0.0f, 0.0f);
		 * animation1.setDuration(3000); sldimg.startAnimation(animation1); x++;
		 * sldimg.setBackgroundResource(R.drawable.imagebanner3);
		 * 
		 * }
		 */

		fb.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String url = "http://www.facebook.com/Aranya2k14";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});

		yt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			String url = "https://www.youtube.com/channel/UCKynwuH5_sAX3pNXfk1J_LA";
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse(url));
			startActivity(i);
			}
		});

		events_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// events_btn.getBackground().setColorFilter(Color.BLACK,
				// PorterDuff.Mode.DARKEN);
				v.startAnimation(AnimationUtils.loadAnimation(HomeTest2.this,
						R.anim.imagealpha));
				Intent i = new Intent(HomeTest2.this, Events.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(i, 0);
			}
		});
		sponsors.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// events_btn.getBackground().setColorFilter(Color.BLACK,
				// PorterDuff.Mode.DARKEN);
				v.startAnimation(AnimationUtils.loadAnimation(HomeTest2.this,
						R.anim.imagealpha));
				Intent i = new Intent(HomeTest2.this, Sponsors.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(i, 0);
			}
		});
		starnight_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// events_btn.getBackground().setColorFilter(Color.BLACK,
				// PorterDuff.Mode.DARKEN);
				v.startAnimation(AnimationUtils.loadAnimation(HomeTest2.this,
						R.anim.imagealpha));
				Intent i = new Intent(HomeTest2.this, StarNight.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(i, 0);
			}
		});

		schedule_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				v.startAnimation(AnimationUtils.loadAnimation(HomeTest2.this,
						R.anim.imagealpha));
				Intent i = new Intent(HomeTest2.this, Schedule.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(i, 0);
			}
		});
		// populate the list using the array adapter

		// listview.setAdapter(new
		// ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));

		listview.setAdapter(myAdapter);
		listview.setOnItemClickListener(this);
		drawerlistener = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {

			@Override
			public void onDrawerOpened(View drawerView) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub

			}

		};
		drawerLayout.setDrawerListener(drawerlistener);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (drawerlistener.onOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerlistener.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerlistener.syncState();
	}

	// code for on itemclickListener.
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		selectItem(position);
		if (position == 1) {

			Intent i = new Intent(HomeTest2.this, ContactUs.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivityForResult(i, 0);

		} else if (position == 3) {
			// bhalu enter your code

			Intent i = new Intent(HomeTest2.this, Settings.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivityForResult(i, 0);

		} else if (position == 4) {

			Intent i = new Intent(HomeTest2.this, Developer.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivityForResult(i, 0);

		} else if (position == 2) {

			Intent i = new Intent(HomeTest2.this, AboutUs.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivityForResult(i, 0);

		}

	}

	public void selectItem(int position) {
		listview.setItemChecked(position, true);
		// setTitle(items[position]);

		// TODO Auto-generated method stub

	}

	public void setTitle(String title) {
		getSupportActionBar().setTitle(title);
	}

	class MyAdapter extends BaseAdapter {

		private Context context;
		String[] items1;

		int[] images = { R.drawable.home2, R.drawable.contactus2,
				R.drawable.aboutus2, R.drawable.settings,
				R.drawable.developers2 };

		public MyAdapter(Context context) {
			this.context = context;
			items1 = context.getResources().getStringArray(R.array.items);

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items1.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return items1[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View row = null;
			if (convertView == null) {
				LayoutInflater inflator = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				row = inflator.inflate(R.layout.navigationlist_inflator_layout,
						parent, false);

			} else {
				row = convertView;
			}
			TextView navigation_text = (TextView) row
					.findViewById(R.id.textView1);
			navigation_image = (ImageView) row.findViewById(R.id.imageView1);
			navigation_text.setText(items1[position]);
			navigation_image.setImageResource(images[position]);

			return row;
		}

	}

}
