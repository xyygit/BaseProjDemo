package com.yann.advance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yann.advance.adapter.HomeRecyclerViewAdapter;
import com.yann.advance.base.BaseActivity;
import com.yann.advance.db.DataActivity;
import com.yann.advance.entitry.HomeItem;
import com.yann.advance.log.LogTestActivity;
import com.yann.advance.view.BaseToolBar;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private static final Class<?>[] ACTIVITY = {LogTestActivity.class, DataActivity.class};
    private static final String[] TITLE = {"日志测试", "数据库"};
    private static final int[] IMG = {R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    private ArrayList<HomeItem> mDataList;

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    /**
     * 获取当前界面的布局ID
     *
     * @return 当前界面的布局ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initBundle(Bundle savedInstanceState, Intent intent) {
    }

    /**
     * 初始化布局内的控件
     */
    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    /**
     * 初始化相关数据
     */
    @Override
    protected void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }

        initAdapter();
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
        toolbar.setVisibility(View.GONE);
    }

    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeRecyclerViewAdapter(R.layout.home_item_view, mDataList);
        homeAdapter.openLoadAnimation();
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) recyclerView.getParent(), false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(homeAdapter);
    }
}
