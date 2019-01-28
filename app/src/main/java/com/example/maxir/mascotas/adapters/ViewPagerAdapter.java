package com.example.maxir.mascotas.adapters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.maxir.mascotas.fragments.MiMascotaFragment;
import com.example.maxir.mascotas.fragments.ReciclerViewFragment;

import java.util.ArrayList;

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new ReciclerViewFragment());
        fragments.add(new MiMascotaFragment());
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return 2;
    }

}