package com.aic.loveaichuang.adapter;

import com.aic.loveaichuang.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeListViewAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private int[] mListImageId;
	private String[] mStrList;

	public HomeListViewAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
	}

	public void setData(int[] mListImageId, String[] mStrList) {
		this.mListImageId = mListImageId;
		this.mStrList = mStrList;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mListImageId == null ? 0 : mListImageId.length;
	}

	@Override
	public Object getItem(int position) {
		return mListImageId[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HomeViewHolder homeViewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_listview, null);
			homeViewHolder = new HomeViewHolder(convertView);
			convertView.setTag(homeViewHolder);
		} else {
			homeViewHolder = (HomeViewHolder) convertView.getTag();
		}

		homeViewHolder.image.setImageResource(mListImageId[position % mListImageId.length]);
		if (mStrList != null) {
			homeViewHolder.itemText.setText(mStrList[position % mStrList.length]);
		}
		return convertView;
	}

	class HomeViewHolder {
		ImageView image;
		TextView itemText;

		public HomeViewHolder(View v) {
			image = (ImageView) v.findViewById(R.id.itemImageView);
			itemText = (TextView) v.findViewById(R.id.itemText);
		}

	}

}
