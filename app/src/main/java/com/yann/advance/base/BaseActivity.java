package com.yann.advance.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.yann.advance.R;

import butterknife.ButterKnife;

/**
 * Created by yayun.xia on 2017/11/22.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    private Activity mContext;

    Toast mToast = null;

    protected View contentView;
    protected ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        exProcessOnCreateBefore(savedInstanceState);

        super.onCreate(savedInstanceState);

        if (exInterceptOnCreate(savedInstanceState)) {
            return;
        }

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootViewFrame = layoutInflater.inflate(R.layout.base_container, null);
        progressBar = rootViewFrame.findViewById(R.id.progressbar);
        FrameLayout rootView = rootViewFrame.findViewById(R.id.rootView);

        int layoutId = exInitLayout();
        if (layoutId == 0) {
            contentView = exInitLayoutView();
        } else {
            contentView = layoutInflater.inflate(layoutId, null);
        }
        if (contentView != null) rootView.addView(contentView);

        setContentView(rootViewFrame);

        exInitBundle(savedInstanceState, getIntent());

        exInitView();

        if(!exInterceptInit()) {
            exInitData();
        }

        mContext = this;

        ButterKnife.bind(this);
        Logger.t(TAG);
    }

    /**
     * Method ：在 OnCreate 前执行
     */
    protected abstract void exProcessOnCreateBefore(Bundle savedInstanceState);


    /**
     * Method_拦截 ：对 OnCreate 拦截处理
     *
     * @return 是否拦截 OnCreate
     */
    protected abstract boolean exInterceptOnCreate(Bundle savedInstanceState);


    /**
     * Method_初始化传入参数 ：处理进入之前传入的数据
     */
    protected void exInitBundle(Bundle savedInstanceState, Intent intent) {

    }

    /**
     * Method_初始化布局 ：对展示布局进行设置
     *
     * @return 布局资源 ID
     */
    protected abstract int exInitLayout();

    /**
     * Method_初始化布局 ：对展示布局进行设置
     *
     * @return 布局资源 View
     */
    protected View exInitLayoutView() {
        return null;
    }

    protected abstract boolean exInterceptInit();

    /**
     * Method_初始化控件参数： 在该方法中，可以对已绑定的控件数据初始化
     */
    protected abstract void exInitView();

    /**
     * Method_初始化数据： 在基础数据初始化完成之后可以使用该方法
     */
    protected void exInitData() {

    }

    protected void showToast(final String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
