package com.aic.loveaichuang.activity;

import com.aic.loveaichuang.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

@SuppressLint("InflateParams")
public class InitialActivity extends Activity implements OnPageChangeListener, OnClickListener {

	private ViewPager mViewPager;
	private int[] mImgIdArray;
	private ImageView[] mTrips;
	private View btnMainActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial);
		findViews();
	}

	private void findViews() {
		btnMainActivity = findViewById(R.id.btnMainActivity);
		btnMainActivity.setOnClickListener(this);
		btnMainActivity.setVisibility(View.GONE);
		ViewGroup group = (ViewGroup) findViewById(R.id.initGroupCoircle);
		mViewPager = (ViewPager) findViewById(R.id.initViewPager);
		mImgIdArray = new int[] { R.drawable.page_one, R.drawable.page_two, R.drawable.page_three,
				R.drawable.page_four };

		mTrips = new ImageView[mImgIdArray.length];
		group.removeAllViews();
		for (int i = 0; i < mTrips.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setLayoutParams(new LayoutParams(10, 10));
			mTrips[i] = imageView;
			if (i == 0) {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(15, 15);
			lp.setMargins(10, 10, 10, 10);
			group.addView(imageView, lp);
		}

		mViewPager.setAdapter(new InitPagerAdapter());

		mViewPager.addOnPageChangeListener(this);

	}

	public class InitPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImgIdArray.length;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.init_viewpager_view, container,
					false);
			ImageView image = (ImageView) view.findViewById(R.id.initViewPagerImage);
			image.setImageResource(mImgIdArray[position]);
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		setImageBackground(arg0);
		if (arg0 == mTrips.length - 1) {
			btnMainActivity.setVisibility(View.VISIBLE);
		} else {
			btnMainActivity.setVisibility(View.GONE);
		}
	}

	private void setImageBackground(int selectItems) {
		for (int i = 0; i < mTrips.length; i++) {
			if (i == selectItems) {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnMainActivity:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
	}
}
