package com.gmail.huashadow.imagememoryoptimization;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
//        loadImage();
        loadImageWithImageLoader();
    }

    private void loadImageWithImageLoader() {

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(config);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .build();
        ImageView imageView = (ImageView) findViewById(R.id.iv_load_with_imageloader_1);
        ImageLoader.getInstance().displayImage(
                "http://pp.myapp.com/ma_pic2/0/shot_12127266_2_1484188634/550", imageView, options);
    }

    private void loadImage() {
        List<ImageLoaderUtil.ImageInfo> images = new ArrayList<>();
        ImageLoaderUtil.ImageInfo imageInfo = new ImageLoaderUtil.ImageInfo(
                "http://pp.myapp.com/ma_pic2/0/shot_12127266_2_1484188634/550",
                "/sdcard/horno_of_king.png");
        images.add(imageInfo);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 4;
        ImageLoaderUtil.loadImages(this, images, new ImageLoaderUtil.OnImageLoadedListener() {
            @Override
            public void onImageLoaded(final Bitmap bitmap, int index) {
                final ImageView imageView = (ImageView) findViewById(R.id.iv_load_myselft);
                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });

            }
        }, options);
    }
}
