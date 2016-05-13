package com.aic.loveaichuang.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.adapter.HomeListViewAdapter;

public class DisTwoFragment extends Fragment implements OnPageChangeListener {
	private View mView;

	private ListView mListView;
	private Context mContext;
	private int[] mImgIdArray;
	private int[] mListImageId;
	private String[] mStrList;
	private ImageView[] mTrips;
	private HomeListViewAdapter mListViewAdapter;
	private ViewPager mViewpager;
	private int index = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.fragment_child_discover_view, null);
		mContext = this.getActivity();
		initData();
		findViews();
		return mView;
	}

	private void initData() {
		mImgIdArray = new int[] { R.drawable.header_one, R.drawable.header_two, R.drawable.header_three,
				R.drawable.header_four, R.drawable.header_five, R.drawable.header_six, R.drawable.header_serven };
		mListImageId = new int[] { R.drawable.list_1, R.drawable.list_2, R.drawable.list_3, R.drawable.list_4,
				R.drawable.list_5, R.drawable.list_6, R.drawable.list_7, R.drawable.list_8, R.drawable.list_9,
				R.drawable.list_10 };

		mStrList = getResources().getStringArray(R.array.StrList);
	}

	private void findViews() {
		mListView = (ListView) mView.findViewById(R.id.homeListView);
		mListViewAdapter = new HomeListViewAdapter(mContext);
		mListView.setAdapter(mListViewAdapter);
		mListViewAdapter.setData(mListImageId, mStrList);

	}

	@SuppressLint("InflateParams")
	private void addHeaderListView() {
		View view = LayoutInflater.from(mContext).inflate(R.layout.home_header_viewpager, null);
		ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.viewPagerGroupCoircle);
		mViewpager = (ViewPager) view.findViewById(R.id.homeHeaderViewPager);
		mViewpager.addOnPageChangeListener(this);
		mViewpager.setAdapter(new HeaderViewPagerAdapter());
		mListView.addHeaderView(view);

		mTrips = new ImageView[mImgIdArray.length];
		viewGroup.removeAllViews();
		for (int i = 0; i < mTrips.length; i++) {
			ImageView imageView = new ImageView(mContext);
			imageView.setLayoutParams(new LayoutParams(10, 10));
			mTrips[i] = imageView;
			if (i == 0) {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(15, 15);
			lp.setMargins(10, 10, 10, 10);
			viewGroup.addView(imageView, lp);
		}
		if (index == 0) {
			mHandler.sendEmptyMessageDelayed(index++, 1500);
		}
	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			mViewpager.setCurrentItem(index % mImgIdArray.length);
			mHandler.sendEmptyMessageDelayed(index++, 1500);
		};
	};

	private void setImageBackground(int selectItems) {
		for (int i = 0; i < mTrips.length; i++) {
			if (i == selectItems) {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				mTrips[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
			}
		}
	}

	public class HeaderViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImgIdArray.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = LayoutInflater.from(mContext).inflate(R.layout.init_viewpager_view, container, false);
			ImageView image = (ImageView) view.findViewById(R.id.initViewPagerImage);
			image.setImageResource(mImgIdArray[position]);
			container.addView(view);
			return view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
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
	}

}
