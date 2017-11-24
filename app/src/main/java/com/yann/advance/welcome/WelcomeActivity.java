package com.yann.advance.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yann.advance.MainActivity;
import com.yann.advance.R;
import com.yann.advance.base.BaseActivity;
import com.yann.advance.view.BaseToolBar;
import com.yann.advance.welcome.view.ParticleView;

import butterknife.BindView;

/**
 * Created by yayun.xia on 2017/11/24.
 */

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.pv)
    ParticleView pv;

    /**
     * 获取当前界面的布局ID
     *
     * @return 当前界面的布局ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initBundle(Bundle savedInstanceState, Intent intent) {

    }

    /**
     * 初始化布局内的控件
     */
    @Override
    protected void initView() {
        pv.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });
        pv.startAnim();
    }

    /**
     * 初始化相关数据
     */
    @Override
    protected void initData() {

    }

    @Override
    protected int getStatusColor() {
        return -1;
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
