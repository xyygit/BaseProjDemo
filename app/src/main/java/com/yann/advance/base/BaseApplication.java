package com.yann.advance.base;

import android.app.Application;
import android.content.Context;

import com.yann.advance.Utils.ExAppUtil;
import com.yann.advance.log.LoggerUtils;

/**
 * Created by yayun.xia on 2017/11/21.
 */

public class BaseApplication extends Application {

    private static Context instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = getApplicationContext();

        ExAppUtil.getInstance().setContext(instance);

        init();
    }

    private void init() {
        LoggerUtils.getInstance().init();
    }

    public static void resetApplicationContext() {
        ExAppUtil.getInstance().setContext(instance);
    }
}
