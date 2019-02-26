package com.example.sampleapp;

import android.app.Activity;
import android.os.Bundle;

import com.example.sampleapp.databinding.ActivityTabPagerViewBinding;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerViewActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    ActivityTabPagerViewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_tab_pager_view);


        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.tabLayout.addOnTabSelectedListener(this);
        CustomPagerAdapter customPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
          customPagerAdapter.setFragmentList(new FragmentOne());
          customPagerAdapter.setFragmentList(new FragmentTwo());
          customPagerAdapter.setName(new String[]{"One","Two"});
          binding.tabLayout.addTab(binding.tabLayout.newTab());
          binding.tabLayout.addTab(binding.tabLayout.newTab());
        binding.viewPager.setAdapter(customPagerAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        binding.viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
