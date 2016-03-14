package com.fuxuemingzhu.findjoy.module.bigimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fuxuemingzhu.findjoy.R;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

@RequiresPresenter(BigImagePresenter.class)
public class BigImageActivity extends BeamBaseActivity<BigImagePresenter> {

    @Bind(R.id.pv_big_image)
    ImageView iv_big_image;

    @Bind(R.id.fab_big_image)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);

        ButterKnife.bind(this);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String imageUrl = bundle.getString("imageUrl");

        Glide.with(this).load(imageUrl).into(iv_big_image);

        fab.setOnClickListener(view -> Snackbar.make(view, "should download image", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

}
