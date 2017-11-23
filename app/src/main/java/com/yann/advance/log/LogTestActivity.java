package com.yann.advance.log;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.orhanobut.logger.Logger;
import com.yann.advance.R;
import com.yann.advance.base.BaseActivity;
import com.yann.advance.view.BaseToolBar;
import com.yann.advance.view.StatusBarCompat;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 日志测试
 */
public class LogTestActivity extends BaseActivity {

    @BindView(R.id.btn1)
    Button btn1;

    public static void launcher(Context context) {
        context.startActivity(new Intent(context, LogTestActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_log_test;
    }

    @Override
    protected void initBundle(Bundle savedInstanceState, Intent intent) {

    }

    @Override
    protected void initView() {
        StatusBarCompat.compat(LogTestActivity.this,getResources().getColor(R.color.colorPrimaryDark));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initToolbar(BaseToolBar toolbar) {
        super.initToolbar(toolbar);
        toolbar.setTitle("Log测试页面");
    }

    @Override
    protected int getStatusColor() {
        return getResources().getColor(R.color.colorPrimaryDark);
    }

    // 创建json数据
    private JSONObject createJson() {
        try {
            JSONObject person = new JSONObject();
            person.put("phone", "12315");
            JSONObject address = new JSONObject();
            address.put("country", "china");
            address.put("province", "fujian");
            address.put("city", "xiamen");
            person.put("address", address);
            person.put("married", true);
            return person;
        } catch (JSONException e) {
            Logger.e(e, "create json error occured");
        }
        return null;
    }

    @OnClick(R.id.btn1)
    public void onViewClicked() {
        Logger.d("hello");
        Logger.e("hello");
        Logger.w("hello");
        Logger.v("hello");
        Logger.wtf("hello");
        // 打印json格式
        String json = createJson().toString();
        Logger.t("json").json(json);

    }
}
