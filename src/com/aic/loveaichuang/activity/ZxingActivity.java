package com.aic.loveaichuang.activity;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.utils.DensityUtils;
import com.aic.loveaichuang.zxing.activity.CaptureActivity;
import com.aic.loveaichuang.zxing.encoding.EncodingHandler;
import com.google.zxing.WriterException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ZxingActivity extends Activity {

	private TextView tvResult;
	private EditText etInfo;
	private ImageView ivLogo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zxing);

		tvResult = (TextView) findViewById(R.id.tv_result);
		etInfo = (EditText) findViewById(R.id.et_info);
		ivLogo = (ImageView) findViewById(R.id.iv_logo);

	}

	// 扫描二维码
	public void scan(View v) {

		Intent intent = new Intent(this, CaptureActivity.class);
		startActivityForResult(intent, 1);
	}

	// 得到扫描的结果
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			// 取出二维码中包含的结果
			String key = data.getExtras().getString("result");

			tvResult.setText("扫描的结果: \n\n" + key);
			if (key.startsWith("http")) {
				Intent intent = new Intent();
				intent.setAction("android.intent.action.VIEW");
				Uri content_url = Uri.parse(key);
				intent.setData(content_url);
				startActivity(intent);
			}
		}
	}

	// 生成二维码
	public void scan2(View v) {

		String info = etInfo.getText().toString();
		if (TextUtils.isEmpty(info)) {
			return;
		}

		try {
			// 1.要生成二维码的字符串的信息;2.二维码图片的宽和高
			// 返回一个二维码图片
			Bitmap bitmap = EncodingHandler.createQRCode(info, DensityUtils.dip2px(this, 300));
			ivLogo.setImageBitmap(bitmap);
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}

}
