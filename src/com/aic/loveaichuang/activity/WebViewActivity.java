package com.aic.loveaichuang.activity;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.R.id;
import com.aic.loveaichuang.R.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends Activity {

	public final static String KEY_URL = "url";

	private WebView mWebView;
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view);

		String mUrl = getIntent().getStringExtra(KEY_URL);

		mWebView = (WebView) findViewById(R.id.webView);
		mProgressBar = (ProgressBar) findViewById(R.id.progreaaBar);

		webViewSettings();

		mWebView.loadUrl(mUrl);

	}

	@SuppressLint("SetJavaScriptEnabled")
	private void webViewSettings() {

		WebSettings settings = mWebView.getSettings();
		settings.setSupportZoom(true);
		settings.setJavaScriptEnabled(true);
		settings.setAllowFileAccess(true);
		settings.setUseWideViewPort(true);
		settings.setDomStorageEnabled(true);
		settings.setAllowFileAccess(true);
		settings.setAllowContentAccess(true);

		mWebView.requestFocus(View.FOCUS_DOWN);
		mWebView.requestFocusFromTouch();
		mWebView.setWebChromeClient(new MWebChromeClient());
		mWebView.setWebViewClient(new MWebViewClient());
	}

	class MWebChromeClient extends WebChromeClient {

		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			super.onProgressChanged(view, newProgress);
		}
	}

	class MWebViewClient extends WebViewClient {

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			mProgressBar.setVisibility(View.VISIBLE);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			mProgressBar.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (mWebView.canGoBack()) {
				mWebView.goBack();
			} else {
				finish();
			}
			return true;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

}
