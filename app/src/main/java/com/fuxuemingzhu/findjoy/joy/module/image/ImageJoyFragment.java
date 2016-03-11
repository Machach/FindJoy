package com.fuxuemingzhu.findjoy.joy.module.image;

import android.view.ViewGroup;

import com.fuxuemingzhu.findjoy.model.bean.ImageJoy;
import com.fuxuemingzhu.findjoy.module.image.ImageJoyPresenter;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
@RequiresPresenter(ImageJoyPresenter.class)
public class ImageJoyFragment extends BeamListFragment<ImageJoyPresenter,ImageJoy> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new com.fuxuemingzhu.findjoy.module.image.ImageJoyVH(viewGroup);
    }
    @Override
    protected ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);

    }
}
