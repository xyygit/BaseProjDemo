package com.yann.advance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yann.advance.base.BaseActivity;
import com.yann.advance.log.LogTestActivity;
import com.yann.advance.view.BaseToolBar;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_log) Button btnLog;

    @OnClick(R.id.btn_log)
    public void gotoLogTest(){
        LogTestActivity.launcher(MainActivity.this);
    }

    /**
     * 获取当前界面的布局ID
     *
     * @return 当前界面的布局ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBundle(Bundle savedInstanceState, Intent intent) {

    }

    /**
     * 初始化布局内的控件
     */
    @Override
    protected void initView() {
    }

    /**
     * 初始化相关数据
     */
    @Override
    protected void initData() {

    }

    @Override
    protected int getStatusColor() {
        return 0;
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void initToolbar(BaseToolBar toolbar) {
        super.initToolbar(toolbar);
        toolbar.setVisibility(View.GONE);
    }
}
