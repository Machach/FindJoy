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
import uk.co.senab.photoview.PhotoViewAttacher;

@RequiresPresenter(BigImagePresenter.class)
public class BigImageActivity extends BeamBaseActivity<BigImagePresenter> {

    @Bind(R.id.pv_big_image)
    ImageView iv_big_image;

    @Bind(R.id.fab_big_image)
    FloatingActionButton fab;

    PhotoViewAttacher mAttacher;

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

        mAttacher = new PhotoViewAttacher(iv_big_image);

        mAttacher.setOnPhotoTapListener((view, x, y) -> {
            finish();
        });


    }

}
