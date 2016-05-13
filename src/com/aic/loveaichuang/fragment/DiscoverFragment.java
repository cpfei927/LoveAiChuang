package com.aic.loveaichuang.fragment;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.adapter.MainViewPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
	private ViewPager mViewPager;
	private RadioGroup mRadioGroup;
	private List<Fragment> mFragment;
	private MainViewPagerAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_discover_view, null);
		initFragment();
		mViewPager = ((ViewPager) view.findViewById(R.id.discoverViewPager));
		mRadioGroup = ((RadioGroup) view.findViewById(R.id.discover_RadioGroup));
		((RadioButton) mRadioGroup.getChildAt(0)).setChecked(true);// 默认讲第一个设置为true
		mAdapter = new MainViewPagerAdapter(getActivity().getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
		mAdapter.setFragment(mFragment);
		mRadioGroup.setOnCheckedChangeListener(this);// radioButton的点击监听
		return view;
	}

	private void initFragment() {
		mFragment = new ArrayList<>();
		mFragment.add(new DisOneFragment());
		mFragment.add(new DisTwoFragment());
		mFragment.add(new DisThreeFragment());
		mFragment.add(new DisFourFragment());
	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
		for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
			if (mRadioGroup.getChildAt(i).getId() == checkedId) {
				mViewPager.setCurrentItem(i);
			}
		}
	}
}
