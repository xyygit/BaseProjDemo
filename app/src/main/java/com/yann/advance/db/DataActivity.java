package com.yann.advance.db;

import android.content.Intent;
import android.os.Bundle;

import com.yann.advance.R;
import com.yann.advance.base.BaseActivity;
import com.yann.advance.view.BaseToolBar;

/**
 * Created by yayun.xia on 2017/11/23.
 */

public class DataActivity extends BaseActivity {
    /**
     * 获取当前界面的布局ID
     *
     * @return 当前界面的布局ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_data;
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
        return getResources().getColor(R.color.colorPrimaryDark);
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void initToolbar(BaseToolBar toolbar) {
        super.initToolbar(toolbar);
        toolbar.setTitle("数据库测试");
    }
}
