package com.example.e_commerce;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WelcomePagerAdaptor extends FragmentPagerAdapter {

    private Activity activity;

    public WelcomePagerAdaptor(Activity activity,@NonNull FragmentManager fm) {
        super(fm);
        this.activity = activity;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return WelcomeFragmentViewPager.newInstance(activity.getString(R.string.second_title),activity.getString(R.string.second_desc),R.drawable.second_welcome);
            case 2:
                return WelcomeFragmentViewPager.newInstance(activity.getString(R.string.third_title),activity.getString(R.string.third_desc),R.drawable.third_welcome);
            case 3:
                return WelcomeFragmentViewPager.newInstance(activity.getString(R.string.fourth_title),activity.getString(R.string.fourth_desc),R.drawable.fourth_welcome);

            case 0:
            default:
                return WelcomeFragmentViewPager.newInstance(activity.getString(R.string.first_title),activity.getString(R.string.first_desc),R.drawable.first_welcome);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
