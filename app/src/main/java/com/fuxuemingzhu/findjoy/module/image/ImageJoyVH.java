package com.fuxuemingzhu.findjoy.module.image;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fuxuemingzhu.findjoy.R;
import com.fuxuemingzhu.findjoy.model.bean.ImageJoy;
import com.fuxuemingzhu.findjoy.utils.RecentDateFormat;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.utils.JTimeTransform;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
public class ImageJoyVH extends BaseViewHolder<ImageJoy> {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.time)
    TextView time;

    public ImageJoyVH(ViewGroup parent) {
        super(parent, R.layout.item_joy_image);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(ImageJoy data) {
        title.setText(data.getTitle());
        Glide.with(getContext()).load(data.getImg()).into(image);
        time.setText(new JTimeTransform().parse("yyyy-MM-dd hh:mm:ss",data.getCt()).toString(new RecentDateFormat()));
    }
}
