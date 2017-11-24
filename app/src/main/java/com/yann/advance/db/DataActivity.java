package com.yann.advance.db;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yann.advance.R;
import com.yann.advance.base.BaseActivity;
import com.yann.advance.db.sqlite.SQLiteActivity;
import com.yann.advance.view.BaseToolBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yayun.xia on 2017/11/23.
 */

public class DataActivity extends BaseActivity {
    @BindView(R.id.tv_sqlite)
    TextView tvSqlite;
    @BindView(R.id.tv_grenndao)
    TextView tvGrenndao;
    @BindView(R.id.tv_realm)
    TextView tvRealm;
    @BindView(R.id.ormlite)
    TextView ormlite;

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


    @OnClick({R.id.tv_sqlite, R.id.tv_grenndao, R.id.tv_realm, R.id.ormlite})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sqlite:
                launcher(SQLiteActivity.class);
                break;
            case R.id.tv_grenndao:
                break;
            case R.id.tv_realm:
                break;
            case R.id.ormlite:
                break;
        }
    }
}
