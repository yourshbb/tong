/*
 * Copyright 2014 zenghui.wang.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mobilepower.tong.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

import com.mobilepower.tong.R;
import com.mobilepower.tong.TongApplication;
import com.mobilepower.tong.ui.view.CustomAvatarView;
import com.squareup.otto.Bus;

public class SelfPageActivity extends BaseActivity implements OnClickListener {

	private Bus bus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.self_page_activity);
		bus = TongApplication.getBus();

		initView();
		initData();
	}

	private CustomAvatarView mAvatarView;

	// 按钮 选项
	private View mChatBtn;
	private View mFriendBtn;
	private View mScoreDesBtn;
	private View mAboutBtn;
	private CheckBox mWantPush;
	private CheckBox mNearbyUser;

	private void initView() {
		mAvatarView = (CustomAvatarView) findViewById(R.id.self_pate_avatar);
		mAvatarView.setOnClickListener(this);

		mChatBtn = findViewById(R.id.self_page_chat_btn);
		mFriendBtn = findViewById(R.id.self_page_friend_btn);
		mScoreDesBtn = findViewById(R.id.self_page_score_des_btn);
		mAboutBtn = findViewById(R.id.self_page_about_btn);

		mWantPush = (CheckBox) findViewById(R.id.setting_want_info_push);
		mNearbyUser = (CheckBox) findViewById(R.id.setting_nearby_user);

		mChatBtn.setOnClickListener(this);
		mFriendBtn.setOnClickListener(this);
		mScoreDesBtn.setOnClickListener(this);
		mAboutBtn.setOnClickListener(this);
	}

	private void initData() {
		mAvatarView
				.setImageUrl("http://ww2.sinaimg.cn/bmiddle/684ff39bgw1ejfep2t9bcj20sg0ixq50.jpg");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		this.bus.register(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		this.bus.unregister(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == mAvatarView) {
			Intent intent = new Intent();
			intent.setClass(this, UserInfoActivity.class);
			this.startActivity(intent);
		} else if (v == mChatBtn) {
			Intent intent = new Intent();
			intent.setClass(this, ChatActivity.class);
			this.startActivity(intent);
		} else if (v == mFriendBtn) {
			Intent intent = new Intent();
			intent.setClass(this, FriendsActivity.class);
			this.startActivity(intent);
		} else if (v == mScoreDesBtn) {
			Intent intent = new Intent();
			intent.setClass(this, ScoreDescActivity.class);
			this.startActivity(intent);
		} else if (v == mAboutBtn) {
			Intent intent = new Intent();
			intent.setClass(this, AboutActivity.class);
			this.startActivity(intent);
		}
	}

}
