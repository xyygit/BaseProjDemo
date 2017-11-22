package com.yann.advance;

import android.os.Bundle;
import android.widget.Button;

import com.yann.advance.base.BaseActivity;
import com.yann.advance.log.LogTestActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_log) Button btnLog;

    @Override
    protected void exProcessOnCreateBefore(Bundle savedInstanceState) {
    }

    @Override
    protected boolean exInterceptOnCreate(Bundle savedInstanceState) {
        return false;
    }

    @Override
    protected int exInitLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected boolean exInterceptInit() {
        return false;
    }

    @Override
    protected void exInitView() {

    }

    @OnClick(R.id.btn_log)
    public void gotoLogTest(){
        LogTestActivity.launcher(MainActivity.this);
    }

}
