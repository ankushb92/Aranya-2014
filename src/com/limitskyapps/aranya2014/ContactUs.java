package com.limitskyapps.aranya2014;

import com.limitskyapps.aranya2014.Home.MyAdapter;

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

public class ContactUs extends Activity{
	private ListView contactlist;
	private ContactAdapter contactAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_contactus);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00bf8f")));
		bar.setTitle("Contact Us");

		bar.setDisplayHomeAsUpEnabled(true);


		contactlist=(ListView)findViewById(R.id.listView1);
		contactAdapter=new ContactAdapter(this);
		contactlist.setAdapter(contactAdapter);


	}


	private class ContactAdapter extends BaseAdapter{

		private Context context;

		int [] images={R.drawable.contactpic3,R.drawable.contactpic4,R.drawable.contactpic2,R.drawable.contactpic1,R.drawable.harshit};

		String []name ={"Divya Soni","Rishabhjeet Kaur","Shubhankar Shukla ","Lovish Saluja","Harshit Bansal "};
		String []designation={"Overall Student Coordinator","Deputy Student Coordinator","Marketing Head","Technical Head","Publicity Head"};
		String []email={"oscaranya9@gmail.com ","doscaranya9@gmail.com","homdaranya9@gmail.com","hotdaranya9@gmail.com","hopdaranya9@gmail.com"};


		public ContactAdapter(Context c){
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

				row=inflator.inflate(R.layout.contactus_inflator,parent,false);


			}
			else{
				row=convertView;	  
			}
			TextView contact_name=(TextView)row.findViewById(R.id.Name);
			TextView contact_desig=(TextView)row.findViewById(R.id.Designation);
			TextView contact_email=(TextView)row.findViewById(R.id.email);

			contact_name.setText(name[position]);
			contact_desig.setText(designation[position]);
			contact_email.setText(email[position]);

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
