package com.yann.advance.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yann.advance.R;
import com.yann.advance.entitry.HomeItem;

import java.util.List;

/**
 * Created by yayun.xia on 2017/11/24.
 */

public class HomeRecyclerViewAdapter extends BaseQuickAdapter<HomeItem,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public HomeRecyclerViewAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text_home,item.getTitle());
        helper.setImageResource(R.id.icon_home,item.getImageResource());
    }
}
