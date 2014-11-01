package com.limitskyapps.aranya2014;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter_AboutUs extends FragmentPagerAdapter{

	public TabsPagerAdapter_AboutUs(FragmentManager fm) {
        super(fm);
    }
	
	@Override
	public Fragment getItem(int index) {
		// TODO Auto-generated method stub
		switch(index)
		{
		case 0:
          
            return new TuFragment();
        case 1:
    
            return new AranyaFragment();
        case 2:
            
            return new CsrFragment();	
		
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
