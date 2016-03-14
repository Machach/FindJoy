package com.fuxuemingzhu.findjoy.module.bigimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;

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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_image);

        ButterKnife.bind(this);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String imageUrl = bundle.getString("imageUrl");

        getPresenter().getImage(imageUrl);


        fab.setOnClickListener(view -> getPresenter().saveImage(imageUrl));

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

}
