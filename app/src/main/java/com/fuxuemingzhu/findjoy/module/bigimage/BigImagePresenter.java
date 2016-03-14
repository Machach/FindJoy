package com.fuxuemingzhu.findjoy.module.bigimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.fuxuemingzhu.findjoy.model.image.ImageStorage;
import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;

/**
 * 包名：com.fuxuemingzhu.findjoy.module.bigimage
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2016/3/13 22:04
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2016/3/13 22:04
 * 修改备注：
 *
 * @version 1.0
 */
public class BigImagePresenter extends Presenter<BigImageActivity> {
    @Override
    protected void onCreate(BigImageActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
    }

    public void getImage(String imageUrl) {
        Glide.with(getView()).load(imageUrl).into(getView().iv_big_image);
    }

    public void saveImage(String imageUrl) {

        String[] names = new String[0];
        if (imageUrl != null) {
            names = imageUrl.split("/");
        }
        String imageName = names[names.length - 1];
        Glide
                .with(getView())
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
                                    Snackbar.make(getView().fab, "图片已存在", Snackbar
                                            .LENGTH_LONG)
                                            .setAction("Action", null).show();
                                    return null;
                                }
                                String path = Environment.getExternalStorageDirectory().toString();
                                JUtils.Log("path", path);

                                Bitmap bitmap = BitmapFactory.decodeByteArray(resource, 0, resource.length);
                                JUtils.Log("imageName", imageName);

                                ImageStorage.saveToSdCard(getView(), bitmap, imageName);

                                Snackbar.make(getView().fab, "图片已下载", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();

                                return null;
                            }
                        }.execute();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreateView(BigImageActivity view) {
        super.onCreateView(view);
    }

    @Override
    protected void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
    }
}
