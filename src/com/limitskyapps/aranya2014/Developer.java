package com.limitskyapps.aranya2014;





import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Developer extends Activity{
	private ListView devlist;
	private DeveloperAdapter devAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_developer);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Developers");

		bar.setDisplayHomeAsUpEnabled(true);
		devlist=(ListView)findViewById(R.id.listView1);
		devAdapter=new DeveloperAdapter(this);
		devlist.setAdapter(devAdapter);

		
	}

	private class DeveloperAdapter extends BaseAdapter{

		private Context context;

		int [] images={R.drawable.ankushimage,R.drawable.nikitimage};

		String []name ={"Ankush Bhalotia","Nikit Prabhu"};
		

		public DeveloperAdapter(Context c){
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

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View row=null;
			if(convertView==null){
				LayoutInflater inflator=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);	 

				row=inflator.inflate(R.layout.developer_inflator,parent,false);


			}
			else{
				row=convertView;	  
			}
			TextView contact_name=(TextView)row.findViewById(R.id.textView1);
		
			contact_name.setText(name[position]);
		
			ImageView contact_image=(ImageView)row.findViewById(R.id.imageView1);
			contact_image.setImageResource(images[position]);  


			return row;
		}


	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	}
