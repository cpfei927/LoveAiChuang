package com.aic.loveaichuang.activity;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.R.id;
import com.aic.loveaichuang.R.layout;
import com.aic.loveaichuang.fragment.AddFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class LoginActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		AddFragment addFragment = new AddFragment();

		getSupportFragmentManager().beginTransaction().add(R.id.container, addFragment).commit();

	}
}
