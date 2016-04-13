package com.aic.loveaichuang.fragment;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.activity.WebViewActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MoreFragment extends Fragment implements OnClickListener {

	public final static String huodong = "http://m.zcool.com.cn/activities?from=zcoolapp";
	public final static String meishi = "http://m.hellorf.com/";
	public final static String yuLe = "http://m.idea.zcool.com.cn/?from=zcoolapp";
	public final static String chuangyi = "http://m.zcool.com.cn/event/eventlist.do?from=zcoolapp";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_more_view, null);

		view.findViewById(R.id.huoDongLinear).setOnClickListener(this);
		view.findViewById(R.id.meishiLinear).setOnClickListener(this);
		view.findViewById(R.id.yuLeLinear).setOnClickListener(this);
		view.findViewById(R.id.chuangyiLinear).setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {

		Intent intent = new Intent();

		switch (v.getId()) {
		case R.id.huoDongLinear:
			intent.putExtra(WebViewActivity.KEY_URL, huodong);
			break;
		case R.id.meishiLinear:
			intent.putExtra(WebViewActivity.KEY_URL, meishi);
			break;
		case R.id.yuLeLinear:
			intent.putExtra(WebViewActivity.KEY_URL, yuLe);
			break;
		case R.id.chuangyiLinear:
			intent.putExtra(WebViewActivity.KEY_URL, chuangyi);
			break;

		default:
			break;
		}
		intent.setClass(getActivity(), WebViewActivity.class);
		startActivity(intent);
	}
}
