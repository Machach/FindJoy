package com.fuxuemingzhu.findjoy.joy.module.text;

import android.view.ViewGroup;

import com.fuxuemingzhu.findjoy.model.bean.TextJoy;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Mr.Jude on 2015/8/20.
 */
@RequiresPresenter(TextJoyPresenter.class)
public class TextJoyFragment extends BeamListFragment<TextJoyPresenter,TextJoy> {
    @Override
    protected BaseViewHolder getViewHolder(ViewGroup viewGroup, int i) {
        return new com.fuxuemingzhu.findjoy.module.text.TextJoyVH(viewGroup);
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
