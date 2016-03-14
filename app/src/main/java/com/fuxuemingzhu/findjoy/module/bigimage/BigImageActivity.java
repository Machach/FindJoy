package com.fuxuemingzhu.findjoy.module.bigimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.fuxuemingzhu.findjoy.R;
import com.fuxuemingzhu.findjoy.model.ImageStorage;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.utils.JUtils;

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
        String[] names = new String[0];
        if (imageUrl != null) {
            names = imageUrl.split("/");
        }
        String imageName = names[names.length - 1];

        Glide.with(this).load(imageUrl).into(iv_big_image);

        fab.setOnClickListener(view -> {
            Glide
                    .with(BigImageActivity.this)
                    .load(imageUrl)
                    .asBitmap()
                    .toBytes(Bitmap.CompressFormat.JPEG, 100)
                    .into(new SimpleTarget<byte[]>() {
                        @Override
                        public void onResourceReady(final byte[] resource, GlideAnimation<? super byte[]> glideAnimation) {
                            new AsyncTask<Void, Void, Void>() {
                                @Override
                                protected Void doInBackground(Void... params) {

                                    if (ImageStorage.checkifImageExists(imageName)) {
                                        Snackbar.make(view, "图片已存在", Snackbar.LENGTH_LONG)
                                                .setAction("Action", null).show();
                                        return null;
                                    }
                                    String path = Environment.getExternalStorageDirectory().toString();
                                    JUtils.Log("path", path);

                                    Bitmap bitmap = BitmapFactory.decodeByteArray(resource, 0, resource.length);
                                    JUtils.Log("imageName", imageName);

                                    ImageStorage.saveToSdCard(BigImageActivity.this, bitmap, imageName);

                                    Snackbar.make(view, "图片已下载", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();

                                    return null;
                                }
                            }.execute();
                        }
                    });


        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

}
