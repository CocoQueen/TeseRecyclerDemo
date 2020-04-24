package com.example.teserecyclerdemo;

import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @Author Coco
 * @ClassName TestAdapter
 * @Date 2020/4/23 18:08
 * @Description TODO
 */
public class TestAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {
    public TestAdapter(@Nullable List<Integer> data) {
        super(R.layout.item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        TextView textView = helper.getView(R.id.tv);
        textView.setText(item + "");
    }
}
