package com.aic.loveaichuang.chat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.aic.loveaichuang.R;
import com.aic.loveaichuang.utils.TimeUtils;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Activity implements OnClickListener {
	private Button mBtnSend;
	private Button mBtnBack;
	private EditText mEditTextContent;
	// 聊天内容的适配器
	private ChatMsgViewAdapter mAdapter;
	private ListView mListView;
	// 聊天的内容
	private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		setContentView(R.layout.chat);
		initView();
		initData();
	}

	// 初始化视图
	private void initView() {
		mListView = (ListView) findViewById(R.id.listview);
		mBtnBack = (Button) findViewById(R.id.btn_back);
		mBtnBack.setOnClickListener(this);
		mBtnSend = (Button) findViewById(R.id.btn_send);
		mBtnSend.setOnClickListener(this);
		mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);
	}

	private String[] msgArray = new String[] { "  孩子们，要好好学习，天天向上！要好好听课，不要翘课！不要挂科，多拿奖学金！三等奖学金的争取拿二等，二等的争取拿一等，一等的争取拿励志！",
			"姚妈妈还有什么吩咐...", "还有，明天早上记得跑操啊，不来的就扣德育分！", "德育分是什么？扣了会怎么样？", "德育分会影响奖学金评比，严重的话，会影响毕业", "哇！学院那么不人道？",
			"你要是你不听话，我当场让你不能毕业！", "我知错了(- -我错在哪了...)" };

	private String[] dataArray = new String[] { "你好贱啊", "张杰是，大傻逼", "我的谢娜呢，我的谢娜呢", "娜娜，快出来， 放大招le", "我知错了(- -我错在哪了...)",
			"孩子们，要好好学习，天天向上！", "要好好听课，不要翘课！不要挂科，多拿奖学金！", "还有，明天早上记得跑操啊，不来的就扣德育分！", "微信表情平台上线之后使用量已超两千万",
			"其实我就是传说中的表情女王喵魂（不知羞耻)", "这套表情是这喵魂这五年来积攒的大头系列500个中", "原创作品：疯狂动物城同人  站酷推荐作品",
			"禁止商业使用；禁止个人使用。 临摹作品，同人作品原型版权归原作者所有。", "介绍：爱情，爱情！", "果膳坊是一家鲜榨果汁连锁店，其饮品均是挑选新鲜成熟的生态水果榨取而成，是健康饮品的首选",
			"果膳坊的品牌风格定位时尚健康又爽畅。品牌文化的传播中，我们紧紧围绕“果汁好功夫”的主题", "因经营的是健康的水果膳食饮料，专烹饪果汁鲜榨等各种水果膳食，所以称之为果膳坊。" };
	private final static int COUNT = 8;

	// 初始化要显示的数据
	private void initData() {
		for (int i = 0; i < COUNT; i++) {
			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(TimeUtils.longDate2String3(System.currentTimeMillis()));
			if (i % 2 == 0) {
				entity.setName("客服妹妹");
				entity.setMsgType(true);
			} else {
				entity.setName("张杰");
				entity.setMsgType(false);
			}

			entity.setText(msgArray[i]);
			mDataArrays.add(entity);
		}
		mAdapter = new ChatMsgViewAdapter(this, mDataArrays);
		mListView.setAdapter(mAdapter);
		mListView.setSelection(mListView.getCount() - 1);
	}

	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btn_back:
			back();
			break;
		case R.id.btn_send:
			send();
			break;
		}
	}

	private void send() {
		String contString = mEditTextContent.getText().toString();
		if (contString.length() > 0) {
			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(getDate());
			entity.setName("张杰");
			entity.setMsgType(false);
			entity.setText(contString);
			mDataArrays.add(entity);
			mAdapter.notifyDataSetChanged();
			mEditTextContent.setText("");
			mListView.setSelection(mListView.getCount() - 1);
			mHandler.sendEmptyMessageDelayed(0, 1000);
		}
	}

	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			defaultReply();
		};
	};

	private void defaultReply() {
		int x = (int) (Math.random() * 100);

		ChatMsgEntity entity = new ChatMsgEntity();
		entity.setDate(getDate());
		entity.setName("客服妹妹");
		entity.setMsgType(true);
		entity.setText(dataArray[x % dataArray.length]);
		mDataArrays.add(entity);
		mAdapter.notifyDataSetChanged();
		mListView.setSelection(mListView.getCount() - 1);
	}

	// 获取日期
	private String getDate() {
		// Calendar c = Calendar.getInstance();
		// String year = String.valueOf(c.get(Calendar.YEAR));
		// String month = String.valueOf(c.get(Calendar.MONTH));
		// String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
		// String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		// String mins = String.valueOf(c.get(Calendar.MINUTE));
		// StringBuffer sbBuffer = new StringBuffer();
		// sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":" +
		// mins);
		// return sbBuffer.toString();

		String longDate2String3 = TimeUtils.longDate2String3(System.currentTimeMillis());

		return longDate2String3;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		back();
		return true;
	}

	private void back() {
		finish();
	}
}
