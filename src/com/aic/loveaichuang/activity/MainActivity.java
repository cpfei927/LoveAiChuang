package com.aic.loveaichuang.activity;

import java.util.ArrayList;
import java.util.List;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.adapter.MainViewPagerAdapter;
import com.aic.loveaichuang.fragment.AddFragment;
import com.aic.loveaichuang.fragment.DiscoverFragment;
import com.aic.loveaichuang.fragment.HomeFragment;
import com.aic.loveaichuang.fragment.MeFragment;
import com.aic.loveaichuang.fragment.MoreFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnPageChangeListener, OnCheckedChangeListener {

	private RadioGroup mRadioGroup;
	private ViewPager mViewPager;
	private MainViewPagerAdapter mAdapter;
	private long lastClickTime;
	private List<Fragment> mFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFragment();
		findViews();
	}
	
	private void initFragment() {
		mFragment = new ArrayList<>();
		mFragment.add(new HomeFragment());
		mFragment.add(new DiscoverFragment());
		mFragment.add(new AddFragment());
		mFragment.add(new MoreFragment());
		mFragment.add(new MeFragment());
	}

	private void findViews() {
		mViewPager = ((ViewPager) findViewById(R.id.mainViewPager));
		mRadioGroup = ((RadioGroup) findViewById(R.id.main_RadioGroup));
		((RadioButton) mRadioGroup.getChildAt(0)).setChecked(true);// 默认讲第一个设置为true
		mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());

		mViewPager.setAdapter(mAdapter);
		mAdapter.setFragment(mFragment);
		mViewPager.addOnPageChangeListener(this);
		mRadioGroup.setOnCheckedChangeListener(this);// radioButton的点击监听
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {
		((RadioButton) mRadioGroup.getChildAt(position)).setChecked(true);
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		// TODO Auto-generated method stub

		for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
			if (mRadioGroup.getChildAt(i).getId() == checkedId) {
				mViewPager.setCurrentItem(i);
			}
		}

	}

	@Override
	public void onBackPressed() {
		long time = System.currentTimeMillis();
		if ((time - lastClickTime) > 1500) {
			Toast.makeText(this, "在按一次返回键退出", Toast.LENGTH_SHORT).show();
		} else {
			finish();
		}
		lastClickTime = time;
	}

}
