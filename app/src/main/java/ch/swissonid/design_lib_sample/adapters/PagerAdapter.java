package ch.swissonid.design_lib_sample.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ch.swissonid.design_lib_sample.R;
import ch.swissonid.design_lib_sample.fragments.tabs.TabFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(getOffset(position));
    }

    private int getOffset(int position){
        switch (position){
            case 0: return 0;
            case 1: return 5;
            case 2: return 10;
            case 3: return 15;
        }
        return 0;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = mContext.getString(R.string.not_title_set);
        switch (position) {
            case 0:
                title = mContext.getString(R.string.pop_title);
                break;
            case 1:
                title = mContext.getString(R.string.indie_title);
                break;
            case 2:
                title = mContext.getString(R.string.rock_title);
                break;
            case 3:
                title = mContext.getString(R.string.r8b_title);
                break;
        }
        return title;
    }


}
