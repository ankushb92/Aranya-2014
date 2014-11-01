package com.limitskyapps.aranya2014;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Hometest extends Activity{
GridView mygrid;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.testhome);
	mygrid=(GridView)findViewById(R.id.gridView1);
	mygrid.setAdapter(new MyAdapter(this));
	
	
}
class MyAdapter extends BaseAdapter{

	private Context mcontext;
	int []images={R.drawable.eventsicon,R.drawable.starnighticon,R.drawable.scheduleicon,R.drawable.sponsorsicon};
	
	public MyAdapter(Context c){
		mcontext=c;
		
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return images.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(mcontext);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(460, 460));
        return imageView;
		
	
	}
	
}

}
