package com.aic.loveaichuang.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

	List<Fragment> fragments;

	public void setFragment(List<Fragment> fragments) {
		this.fragments = fragments;
		notifyDataSetChanged();
	}

	public MainViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments == null ? 0 : fragments.size();
	}

}
