package com.aic.loveaichuang.fragment;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.activity.RegisterAiChuangActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class AddFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_add_view, null);

		view.findViewById(R.id.registerBtn).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivity(new Intent(getActivity(), RegisterAiChuangActivity.class));

			}
		});

		return view;
	}
}
