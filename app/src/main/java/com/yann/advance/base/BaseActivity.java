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
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.yann.advance.R;
import com.yann.advance.view.BaseToolBar;
import com.yann.advance.view.StatusBarCompat;

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
    protected BaseToolBar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootViewFrame = layoutInflater.inflate(R.layout.base_container, null);
        progressBar = rootViewFrame.findViewById(R.id.progressbar);
        toolbar = rootViewFrame.findViewById(R.id.titleBar);
        toolbar.setToolbarTitle((TextView) rootViewFrame.findViewById(R.id.toolbar_title));
        toolbar.setExtendFrame((FrameLayout)rootViewFrame.findViewById(R.id.extendFrame));
        FrameLayout rootView = rootViewFrame.findViewById(R.id.rootView);

        contentView = layoutInflater.inflate(getLayoutId(), null);
        if (contentView != null) rootView.addView(contentView);

        setContentView(rootViewFrame);

        initToolbar(toolbar);

        mContext = this;

        ButterKnife.bind(this);
        Logger.t(TAG);

        initBundle(savedInstanceState, getIntent());

        initView();

        initData();

        StatusBarCompat.compat(this,getStatusColor() == 0 ? getResources().getColor(R.color.colorPrimaryDark) : getStatusColor());
    }

    /**
     * 获取当前界面的布局ID
     *
     * @return 当前界面的布局ID
     */
    protected abstract int getLayoutId();

    protected abstract void initBundle(Bundle savedInstanceState, Intent intent);

    /**
     * 初始化布局内的控件
     */
    protected abstract void initView();

    /**
     * 初始化相关数据
     */
    protected abstract void initData();

    protected abstract int getStatusColor();

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    protected void initToolbar(BaseToolBar toolbar) {
        if(toolbar !=null){
            toolbar.setNavigationIcon(R.drawable.actionbar_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    back();
                }
            });
        }
    }

    protected void back(){
        finish();
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

    protected void launcher(Class cls) {
        mContext.startActivity(new Intent(mContext, cls));
    }
}
