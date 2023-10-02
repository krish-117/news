package com.example.news;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.news.databinding.ActivityMainBinding;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ActivityMainBinding binding;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 1)
            return new Feed();
        else
            return new Discover();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 1)
            title = "Feed";
        else if (position == 0)
            title = "Discover";
        return title;
    }
}
