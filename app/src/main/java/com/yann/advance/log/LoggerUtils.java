package com.yann.advance.log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.yann.advance.BuildConfig;

/**
 * logger框架工具类
 * Logger库能提供的功能:
                         1.线程的信息
                         2.类的信息
                         3.方法的信息
                         4.格式打印json、xml等
                         5.点击链接跳转到源码打印处

 * https://github.com/xyygit/logger
 * Created by yayun.xia on 2017/11/22.
 */

public class LoggerUtils {

    private LoggerUtils(){}

    public static LoggerUtils getInstance(){
        return LoggerUtilsHolder.instance;
    }

    /**
     * 静态内部类
     */
    private static class LoggerUtilsHolder {
        private static final LoggerUtils instance = new LoggerUtils();
    }

    /**
     * 初始化
     */
    public void init(){

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(1)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("logger")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter());

        //TODO: Save logs to the file
        FormatStrategy formatStrategy1 = CsvFormatStrategy.newBuilder()
                .tag("logger")
                .build();

        Logger.addLogAdapter(new DiskLogAdapter(formatStrategy1){
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }

            @Override
            public void log(int priority, String tag, String message) {
                super.log(priority, tag, message);
            }
        });

    }
}
