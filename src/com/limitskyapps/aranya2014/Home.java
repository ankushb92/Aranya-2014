package com.limitskyapps.aranya2014;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Text;

import com.limitskyapps.aranya2014.SplashScreen.PlaceholderFragment;
import android.app.Activity;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.*;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends ActionBarActivity implements OnItemClickListener{

	//intializing the drawer layout and listview
	private DrawerLayout drawerLayout;
	private ListView listview;
	private String[] items;//intializing the array
	private ActionBarDrawerToggle drawerlistener;
	private MyAdapter myAdapter;
	GridView mygrid;
	ImageView navigation_image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//set the layout
		setContentView(R.layout.layout_home);

		//customize the actionbar
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Home");

		//find the views in the layout.
		drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
		listview=(ListView)findViewById(R.id.left_drawer);
		myAdapter=new MyAdapter(this);
		items=getResources().getStringArray(R.array.items); 
		//populate the list using the array adapter

		//listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));

		listview.setAdapter(myAdapter);
		listview.setOnItemClickListener(this);
		drawerlistener=new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_drawer,R.string.drawer_open, R.string.drawer_close){

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

     //gridView
		mygrid=(GridView)findViewById(R.id.gridview);
		//mygrid.setExpanded(true);
		mygrid.setAdapter(new GridAdapter(this));
		
		//onclick for grid view
		mygrid.setOnItemClickListener(new OnItemClickListener() 
		{
		    public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
		    {
		        // this 'mActivity' parameter is Activity object, you can send the current activity.
		    	
		    	
		    	if(position==0){
		    		
		    		
					Intent i=new Intent(Home.this,Events.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivityForResult(i,0);
		    		
		    	}
		       }
		});
		mygrid.setOnTouchListener(new OnTouchListener(){

		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
		        if(event.getAction() == MotionEvent.ACTION_MOVE){
		            return true;
		        }
		        return false;
		    }

		});

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(drawerlistener.onOptionsItemSelected(item)){
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

	//code for on itemclickListener.
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		selectItem(position);
		if(position==1){
			
			Intent i=new Intent(Home.this,ContactUs.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivityForResult(i,0);
			
		}
		else if(position==3){
			//bhalu enter your code
			
			Toast.makeText(this,"Notifications disabled",2000).show();
			
			
			
		}
		else
			if(position==4){
				
				Intent i=new Intent(Home.this,Developer.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivityForResult(i,0);
				
			}
			else
				if(position==2){
					
					Intent i=new Intent(Home.this,AboutUs.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivityForResult(i,0);
					
				}

	}

	public void selectItem(int position) {
		listview.setItemChecked(position, true);
		//setTitle(items[position]);

		// TODO Auto-generated method stub

	}

	public void setTitle(String title){
		getSupportActionBar().setTitle(title);
	}

	class MyAdapter extends BaseAdapter{

		private Context context;
		String [] items1;

		int [] images={R.drawable.home,R.drawable.contactus,R.drawable.aboutus,R.drawable.notification,R.drawable.developers};
		public MyAdapter(Context context){
			this.context=context;
			items1=context.getResources().getStringArray(R.array.items);

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
			View row=null;
			if(convertView==null){
				LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	 

				row=inflator.inflate(R.layout.navigationlist_inflator_layout,parent,false);


			}
			else{
				row=convertView;	  
			}
			TextView navigation_text=(TextView)row.findViewById(R.id.textView1);
			navigation_image=(ImageView)row.findViewById(R.id.imageView1);
			navigation_text.setText(items1[position]);
			navigation_image.setImageResource(images[position]);  


			return row;
		}

	}
	
	private class GridAdapter extends BaseAdapter
	{
	    private List<Item> items = new ArrayList<Item>();
	    private LayoutInflater inflater;

	    public GridAdapter(Context context)
	    {
	        inflater = LayoutInflater.from(context);

	        items.add(new Item("Events", R.drawable.events));
	        items.add(new Item("StarNight", R.drawable.starnight));
	        items.add(new Item("Schedule", R.drawable.schedule));
	        items.add(new Item("Sponsors", R.drawable.sponsors));
	 
	    }

	    @Override
	    public int getCount() {
	        return items.size();
	    }

	    @Override
	    public Object getItem(int i)
	    {
	        return items.get(i);
	    }

	    @Override
	    public long getItemId(int i)
	    {
	        return items.get(i).drawableId;
	    }

	    @Override
	    public View getView(int i, View view, ViewGroup viewGroup)
	    {
	        View v = view;
	        ImageView picture;
	        TextView name;

	        if(v == null)
	        {
	           v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
	           v.setTag(R.id.picture, v.findViewById(R.id.picture));
	           v.setTag(R.id.text, v.findViewById(R.id.text));
	        }

	        picture = (ImageView)v.getTag(R.id.picture);
	        name = (TextView)v.getTag(R.id.text);

	        Item item = (Item)getItem(i);

	        picture.setImageResource(item.drawableId);
	        name.setText(item.name);
	        if(i==0){
	        	name.setBackgroundColor(0x88ffd237);
	        }
	        else if(i==1){
	        	
	        	name.setBackgroundColor(0x8800a2e8);
	        }
	else if(i==2){
		name.setBackgroundColor(0x88b5e61d);
	        }
	else{
		name.setBackgroundColor(0x88ed1c24);
	}

	        return v;
	    }

	    private class Item
	    {
	        final String name;
	        final int drawableId;

	        Item(String name, int drawableId)
	        {
	            this.name = name;
	            this.drawableId = drawableId;
	        }
	    }
	}


}
