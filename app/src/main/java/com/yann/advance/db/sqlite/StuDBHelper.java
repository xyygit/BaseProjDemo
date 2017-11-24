package com.yann.advance.db.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.orhanobut.logger.Logger;

/**
 * Created by yayun.xia on 2017/11/24.
 * http://blog.csdn.net/codeeer/article/details/30237597#
 */

public class StuDBHelper extends SQLiteOpenHelper {

    private static final String TAG = "TestSQLite";
    public static String CREATE_TABLE = "create table stu_table(" +
            "id    int," +
            "sname varchar(20)," +
            "sage  int," +
            "ssex  varchar(10))";

    public static final int VERSION = 1;

    //必须要有构造函数
    public StuDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public StuDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    //当第一次创建数据库的时候，调用该方法
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql = "create table stu_table(id int,sname varchar(20),sage int,ssex varchar(10))";
        //输出创建数据库的日志信息
        Logger.i(TAG, "create Database------------->");
        //execSQL函数用于执行SQL语句
        db.execSQL(CREATE_TABLE);
    }

    //当更新数据库的时候执行该方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //输出更新数据库的日志信息
        Logger.i(TAG, "update Database------------->");
    }
}
