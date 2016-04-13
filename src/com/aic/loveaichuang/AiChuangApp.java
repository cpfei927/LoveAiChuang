package com.aic.loveaichuang;

import android.app.Application;

public class AiChuangApp extends Application {
	
	private static AiChuangApp mInstance;

	public static AiChuangApp getInstance() {
		return mInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
	}

}
