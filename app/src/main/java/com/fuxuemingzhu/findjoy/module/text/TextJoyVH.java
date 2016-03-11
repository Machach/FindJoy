package com.fuxuemingzhu.findjoy.module.text;

import android.view.ViewGroup;
import android.widget.TextView;

import com.fuxuemingzhu.findjoy.R;
import com.fuxuemingzhu.findjoy.model.bean.TextJoy;
import com.fuxuemingzhu.findjoy.utils.RecentDateFormat;
import com.fuxuemingzhu.findjoy.utils.TextFilter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JTimeTransform;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class TextJoyVH extends BaseViewHolder<TextJoy> {
    @Bind(R.id.content)
    TextView content;
    @Bind(R.id.time)
    TextView time;

    public TextJoyVH(ViewGroup parent) {
        super(parent, R.layout.item_joy_text);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(TextJoy data) {
        content.setText(TextFilter.filter(data.getText()));
        time.setText(new JTimeTransform().parse("yyyy-MM-dd hh:mm:ss",data.getCt()).toString(new RecentDateFormat()));
    }
}
