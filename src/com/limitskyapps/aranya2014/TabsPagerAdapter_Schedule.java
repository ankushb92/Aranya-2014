package com.limitskyapps.aranya2014;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter_Schedule extends FragmentPagerAdapter{
	
	public TabsPagerAdapter_Schedule(FragmentManager fm) {
        super(fm);
    }
	
	@Override
	public Fragment getItem(int index) {

		switch(index)
		{
		case 0:            
            return new DayOneFragment();
        case 1:
            return new DayTwoFragment();
        case 2:
            return new DayThreeFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
}
