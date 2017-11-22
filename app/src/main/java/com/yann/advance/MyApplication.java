package com.yann.advance;

import android.app.Application;

import com.yann.advance.log.LoggerUtils;

/**
 * Created by yayun.xia on 2017/11/21.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    public static MyApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        init();
    }

    private void init() {
        LoggerUtils.getInstance().init();
    }
}
