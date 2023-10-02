package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.news.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ViewPagerAdapter viewPagerAdapter;
    Handler delayhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        inIt();
    }

    private void inIt() {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.viewPager.setCurrentItem(1);

        delayhandler = new Handler();
        delayhandler.postDelayed(mUpdateTimeTask, 1);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(0);
            }
        });

        binding.fDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(0);
            }
        });

        binding.forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(1);
            }
        });

        binding.dFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewPager.setCurrentItem(1);
            }
        });
    }

    Runnable mUpdateTimeTask = new Runnable() {
        public void run() {

            if (binding.viewPager.getCurrentItem() == 0) {
                binding.back.setVisibility(View.GONE);
                binding.fDiscover.setVisibility(View.GONE);
                binding.fFeed.setVisibility(View.GONE);

                binding.forward.setVisibility(View.VISIBLE);
                binding.dDiscover.setVisibility(View.VISIBLE);
                binding.dFeed.setVisibility(View.VISIBLE);
            } else if (binding.viewPager.getCurrentItem() == 1) {
                binding.forward.setVisibility(View.GONE);
                binding.dDiscover.setVisibility(View.GONE);
                binding.dFeed.setVisibility(View.GONE);

                binding.back.setVisibility(View.VISIBLE);
                binding.fDiscover.setVisibility(View.VISIBLE);
                binding.fFeed.setVisibility(View.VISIBLE);
            }
            delayhandler.postDelayed(this, 1);
        }
    };
}