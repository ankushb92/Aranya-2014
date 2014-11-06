package com.limitskyapps.aranya2014;



import java.util.ArrayList;
import java.util.List;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Sponsors extends Activity{
	GridView mygrid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sponsor_layout);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Sponsors");
		mygrid=(GridView)findViewById(R.id.gridview);
		//mygrid.setExpanded(true);
		mygrid.setAdapter(new GridAdapter(this));
		
	}
	private class GridAdapter extends BaseAdapter
	{
		private List<Item> items = new ArrayList<Item>();
		private LayoutInflater inflater;

		public GridAdapter(Context context)
		{
			inflater = LayoutInflater.from(context);

			items.add(new Item("Avantha Tech.", R.drawable.avantha));
			items.add(new Item("92.7 Big FM", R.drawable.big));
			items.add(new Item("Aaghaz", R.drawable.aagazh));
			

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
		private int lastPosition = -1;
		@Override
		public View getView(int i, View view, ViewGroup viewGroup)
		{
			View v = view;
			ImageView picture;
			TextView name;

			if(v == null)
			{
				v = inflater.inflate(R.layout.sponsors_inflator, viewGroup, false);
				v.setTag(R.id.picture, v.findViewById(R.id.picture));
				v.setTag(R.id.text, v.findViewById(R.id.text));
			}

			picture = (ImageView)v.getTag(R.id.picture);
			name = (TextView)v.getTag(R.id.text);

			Item item = (Item)getItem(i);

			picture.setImageResource(item.drawableId);
			name.setText(item.name);
			

			
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
