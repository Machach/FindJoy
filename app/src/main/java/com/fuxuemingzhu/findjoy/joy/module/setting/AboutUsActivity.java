package com.fuxuemingzhu.findjoy.joy.module.setting;

import android.os.Bundle;
import android.widget.TextView;

import com.fuxuemingzhu.findjoy.R;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;
import com.umeng.analytics.MobclickAgent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mr.Jude on 2015/8/14.
 */

@RequiresPresenter(AboutUsPresenter.class)
public class AboutUsActivity extends BeamBaseActivity<AboutUsPresenter> {

    @Bind(R.id.version)
    TextView version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        version.setText("v"+ JUtils.getAppVersionName());
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


}
