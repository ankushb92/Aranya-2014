package com.limitskyapps.aranya2014;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
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
import android.content.res.AssetManager;
 
public class OnSpotFragment extends Fragment {
 
	private ListView onSpotlist;
	private OnSpotAdapter onSpotAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	 
        View rootView = inflater.inflate(R.layout.fragment_on_spot, container, false);
    	onSpotlist=(ListView)rootView.findViewById(R.id.listView1);
	    onSpotAdapter=new OnSpotAdapter(getActivity());
		onSpotlist.setAdapter(onSpotAdapter);
        onSpotlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
					
				Intent i=new Intent(getActivity(),EventOnClick.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				i.putExtra("position", position+10);
				startActivityForResult(i, 0);
	    	
			}
		
        });
		
		return rootView;
        
    }

	private class OnSpotAdapter extends BaseAdapter{

		private Context context;
		
		int [] images={R.drawable.code, R.drawable.lock, R.drawable.wind_thrust,R.drawable.trussbridge, R.drawable.contraption, R.drawable.crystal_clear, R.drawable.red, R.drawable.decipher, R.drawable.circuit_trash};

		String []name ={"CODE GOLF", "OPEN THE LOCK", "WIND THRUST","TRUSS BRIDGE MAKING", "CONTRAPTION", 
				"CRYSTAL CLEAR", "CAUGHT RED HANDED", "DECIPHER IT", "CIRCUIT TRASH"};
		

		public OnSpotAdapter(Context c){
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

			Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
			row.startAnimation(animation);
			lastPosition = position;
			return row;
		}

}}