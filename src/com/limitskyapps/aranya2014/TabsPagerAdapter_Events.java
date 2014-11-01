package com.limitskyapps.aranya2014;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter_Events extends FragmentPagerAdapter{

	public TabsPagerAdapter_Events(FragmentManager fm) {
        super(fm);
    }
	
	@Override
	public Fragment getItem(int index) {

		switch(index)
		{
		case 0:            
            return new TechFragment();
        case 1:
            return new SportsFragment();
        case 2:
            return new BizzFragment();	
        case 3:
        	return new OnSpotFragment();
        case 4:
        	return new SSBFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
}