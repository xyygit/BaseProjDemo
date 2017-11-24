package com.yann.advance.db.sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;
import com.yann.advance.R;
import com.yann.advance.base.BaseActivity;
import com.yann.advance.view.BaseToolBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yayun.xia on 2017/11/24.
 * http://blog.csdn.net/codeeer/article/details/30237597#
 */

public class SQLiteActivity extends BaseActivity {
    @BindView(R.id.createDatabase)
    Button createDatabase;
    @BindView(R.id.updateDatabase)
    Button updateDatabase;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.query)
    Button query;
    @BindView(R.id.delete)
    Button delete;

    private StuDBHelper dbHelper;
    private SQLiteDatabase db;

    /**
     * 获取当前界面的布局ID
     *
     * @return 当前界面的布局ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_sqlite;
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
        return 0;
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    @Override
    protected void initToolbar(BaseToolBar toolbar) {
        super.initToolbar(toolbar);
        toolbar.setTitle("SQLiteDatabase测试");
    }

    @OnClick({R.id.createDatabase, R.id.updateDatabase, R.id.insert, R.id.update, R.id.query, R.id.delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.createDatabase:
                //TODO 创建数据库的方法

                //创建StuDBHelper对象
                dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,1);
                //得到一个可读的SQLiteDatabase对象
                db =dbHelper.getReadableDatabase();
                break;
            case R.id.updateDatabase:
                //TODO 更新数据库的方法

                // 数据库版本的更新,由原来的1变为2
                dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,2);
                db =dbHelper.getReadableDatabase();
                break;
            case R.id.insert:
                //TODO 插入数据的方法

                dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,1);
                //得到一个可写的数据库
                db =dbHelper.getWritableDatabase();

                //生成ContentValues对象 //key:列名，value:想插入的值
                ContentValues cv = new ContentValues();
                //往ContentValues对象存放数据，键-值对模式
                cv.put("id", 1);
                cv.put("sname", "xiaoming");
                cv.put("sage", 21);
                cv.put("ssex", "male");
                //调用insert方法，将数据插入数据库
                db.insert("stu_table", null, cv);
                //关闭数据库
                db.close();
                break;
            case R.id.update:
                //TODO 修改数据的方法

                StuDBHelper dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,1);
                //得到一个可写的数据库
                SQLiteDatabase db =dbHelper.getWritableDatabase();
                ContentValues cv1 = new ContentValues();
                cv1.put("sage", "23");
                //where 子句 "?"是占位符号，对应后面的"1",
                String whereClause="id=?";
                String [] whereArgs = {String.valueOf(1)};
                //参数1 是要更新的表名
                //参数2 是一个ContentValeus对象
                //参数3 是where子句
                db.update("stu_table", cv1, whereClause, whereArgs);
                break;
            case R.id.query:
                //TODO 查询数据的方法

                dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,1);
                //得到一个可写的数据库
                db =dbHelper.getReadableDatabase();
                //参数1：表名
                //参数2：要想显示的列
                //参数3：where子句
                //参数4：where子句对应的条件值
                //参数5：分组方式
                //参数6：having条件
                //参数7：排序方式
                Cursor cursor = db.query("stu_table", new String[]{"id","sname","sage","ssex"}, "id=?", new String[]{"1"}, null, null, null);
                while(cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("sname"));
                    String age = cursor.getString(cursor.getColumnIndex("sage"));
                    String sex = cursor.getString(cursor.getColumnIndex("ssex"));
                    Logger.e("query------->" + "姓名："+name+" "+"年龄："+age+" "+"性别："+sex);
                }
                //关闭数据库
                db.close();
                break;
            case R.id.delete:
                //TODO 删除数据的方法

                dbHelper = new StuDBHelper(SQLiteActivity.this,"stu_db",null,1);
                //得到一个可写的数据库
                db =dbHelper.getReadableDatabase();
                String whereClauses = "id=?";
                String [] whereArgs1 = {String.valueOf(2)};
                //调用delete方法，删除数据
                db.delete("stu_table", whereClauses, whereArgs1);
                break;
        }
    }
}
