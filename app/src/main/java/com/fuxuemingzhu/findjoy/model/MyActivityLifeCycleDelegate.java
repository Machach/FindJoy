package com.fuxuemingzhu.findjoy.model;

import android.app.Activity;
import android.os.Bundle;

import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.utils.JUtils;
import com.umeng.analytics.MobclickAgent;

/**
 * 包名：com.fuxuemingzhu.findjoy.model
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2016/3/14 22:40
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2016/3/14 22:40
 * 修改备注：
 *
 * @version 1.0
 */
public class MyActivityLifeCycleDelegate extends ActivityLifeCycleDelegate {
    public MyActivityLifeCycleDelegate(Activity act) {
        super(act);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JUtils.Log("onCreate" + getActivity().getClass().getName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        JUtils.Log("onPause");
        MobclickAgent.onPause(getActivity());
    }

    @Override
    protected void onResume() {
        super.onResume();
        JUtils.Log("onResume");
        MobclickAgent.onResume(getActivity());
    }
}
