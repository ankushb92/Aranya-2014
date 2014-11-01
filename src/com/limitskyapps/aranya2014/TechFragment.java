package com.limitskyapps.aranya2014;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.TextView;
 
public class TechFragment extends Fragment {
	private ListView techlist;
	private TechAdapter techAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_tech, container, false);
    	techlist=(ListView)rootView.findViewById(R.id.listView1);
	    techAdapter=new TechAdapter(getActivity());
		techlist.setAdapter(techAdapter);
        techlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
                if(position==0){
		    		
		    		
					Intent i=new Intent(getActivity(),EventOnClick.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivityForResult(i,0);
		    		
		    	}
			
			}
		
        
        });
		
		return rootView;
        
    }

	private class TechAdapter extends BaseAdapter{

		private Context context;

		int [] images={R.drawable.hover_on,R.drawable.inclino,R.drawable.water_rocket,R.drawable.detector,R.drawable.ideate,R.drawable.arjun,R.drawable.chemicannon};

		String []name ={"HOVER-ON","INCLINO","WATER ROCKET","MIND DETECTOR","IDEATE","ARJUN","CHEMI-CANON"};
		

		public TechAdapter(Context c){
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

				row=inflator.inflate(R.layout.events_inflator,parent,false);


			}
			else{
				row=convertView;	  
			}
			TextView contact_name=(TextView)row.findViewById(R.id.textView1);
		
			contact_name.setText(name[position]);
		
			ImageView contact_image=(ImageView)row.findViewById(R.id.imageView1);
			contact_image.setImageResource(images[position]);  

			Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
			row.startAnimation(animation);
			lastPosition = position;
			return row;
		}

}}